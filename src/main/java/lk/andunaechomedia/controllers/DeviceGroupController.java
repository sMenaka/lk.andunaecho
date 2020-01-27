package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DeviceGroupController {

    @Autowired
    private DeviceGroupRepo device_groupRepo;
    @Autowired
    private MainScheduleRepo mainScheduleRepo;

    @RequestMapping(method = RequestMethod.POST, value = "/add/device_group")
    public @ResponseBody String addGroup(@Valid @RequestBody DeviceGroup group){
        group.setMainSchedule(mainScheduleRepo.findById(group.getMainSchedule().getScheduleId()).get());
        device_groupRepo.save(group);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.GET,path = "get/devices/from/group/{group_id}")
    public @ResponseBody
    DeviceGroup deviceGroup(@PathVariable String group_id){
        return device_groupRepo.findById(group_id).get();
    }

    @RequestMapping(method = RequestMethod.GET,path = "get/devices/from/group/all")
    public @ResponseBody
    Iterable<DeviceGroup> deviceGroups(){
        return device_groupRepo.findAll();
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/device_group/{group_name}")
    public @ResponseBody String deleteDevice_group(@PathVariable String group_id){
        try {
            device_groupRepo.deleteById(group_id );
            return "Group delete Successfully";
        }
        catch (Exception e) {
            return "Group not Found";
        }
    }


}

