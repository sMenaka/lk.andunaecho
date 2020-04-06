package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceGroupController {
    @Autowired
    private DeviceGroupRepo deviceGroupRepo;
    @Autowired
    private MainScheduleRepo mainScheduleRepo;

    public DeviceGroupController() {
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/add/device_group"})
    @ResponseBody
    public String addGroup(@RequestBody DeviceGroup group) {
        String result=null;
        int scheduleNo = 0;
        MainSchedule mainSchedule = null;
        try {
            if (this.mainScheduleRepo.findAll().isEmpty()) {
                scheduleNo = 1;
                mainSchedule = new MainSchedule(Integer.toString(scheduleNo)+ "#" + group.getGroupName().toUpperCase() , 0.1D);
            } else {
                String scheduleId = this.mainScheduleRepo.findTopByOrderByScheduleIdDesc().getScheduleId();
                scheduleNo = Integer.parseInt(scheduleId.substring(scheduleId.indexOf(35) + 1));
                mainSchedule = new MainSchedule(Integer.toString(scheduleNo + 1) + "#" +group.getGroupName().toUpperCase() , 0.1D);
            }

            this.mainScheduleRepo.save(mainSchedule);
            group.setMainSchedule(mainSchedule);
            this.deviceGroupRepo.save(group);
            result="Successfully added "+group.getGroupName()+" group";
        } catch (Exception e){
            result="Oop something have error";
        }

        return result;
    }

    @RequestMapping(
        method = {RequestMethod.GET},
        path = {"get/devices/from/group/{group_id}"}
    )
    @ResponseBody
    public DeviceGroup deviceGroup(@PathVariable String group_id) {
        return (DeviceGroup)this.deviceGroupRepo.findById(group_id).get();
    }

    @RequestMapping(
        method = {RequestMethod.GET},
        path = {"get/devices/from/group/all"}
    )
    @ResponseBody
    public Iterable<DeviceGroup> deviceGroups() {
        return this.deviceGroupRepo.findAll();
    }

    @RequestMapping(
        method = {RequestMethod.DELETE},
        path = {"/delete/device_group/{group_name}"}
    )
    @ResponseBody
    public String deleteDevice_group(@PathVariable String group_id) {
        try {
            this.deviceGroupRepo.deleteById(group_id);
            return "Group delete Successfully";
        } catch (Exception var3) {
            return "Group not Found";
        }
    }
}
