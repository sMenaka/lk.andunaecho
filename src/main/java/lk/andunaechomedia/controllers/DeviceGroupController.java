package lk.andunaechomedia.controllers;

import lk.andunaechomedia.dtos.SaveGroupDto;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import lk.andunaechomedia.services.impl.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceGroupController {
    @Autowired
    private GroupServiceImpl groupService;
    @Autowired
    private MainScheduleRepo mainScheduleRepo;

    public DeviceGroupController() {
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/add/device_group"})
    @ResponseBody
    public HttpEntity<SaveGroupDto> addGroup(@RequestBody SaveGroupDto group) {
        try{
            return  new ResponseEntity(groupService.saveGroup(group), HttpStatus.CREATED);
        }catch (Exception e){
            return  new ResponseEntity(group, HttpStatus.BAD_REQUEST);
        }



    }

//    @RequestMapping(
//        method = {RequestMethod.GET},
//        path = {"get/devices/from/group/{group_id}"}
//    )
//    @ResponseBody
//    public DeviceGroup deviceGroup(@PathVariable String group_id) {
//        return (DeviceGroup)this.deviceGroupRepo.findById(group_id).get();
//    }
//
//    @RequestMapping(
//        method = {RequestMethod.GET},
//        path = {"get/devices/from/group/all"}
//    )
//    @ResponseBody
//    public Iterable<DeviceGroup> deviceGroups() {
//        return this.deviceGroupRepo.findAll();
//    }
//
//    @RequestMapping(
//        method = {RequestMethod.DELETE},
//        path = {"/delete/device_group/{group_name}"}
//    )
//    @ResponseBody
//    public String deleteDevice_group(@PathVariable String group_id) {
//        try {
//            this.deviceGroupRepo.deleteById(group_id);
//            return "Group delete Successfully";
//        } catch (Exception var3) {
//            return "Group not Found";
//        }
//    }
}
