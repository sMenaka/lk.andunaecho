package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.models.Device_group;
import lk.andunaechomedia.repositories.Device_groupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Device_groupController {

    @Autowired
    private Device_groupRepo device_groupRepo;

    @RequestMapping(method = RequestMethod.POST, value = "/add/device_group")
    public @ResponseBody
    String addGroup(@RequestBody Device_group device_group){
        Device_group tempDevice_group = device_groupRepo.findById(device_group.getGroup_id()).get();
        if (device_group != null){
            System.out.println(device_group.getGroup_name());
            device_groupRepo.save(device_group);
            return "Group Created";
        }
        return "Group Creation Failed";
    }

    @RequestMapping(method = RequestMethod.GET,path = "get/devices/from/group/{group_name}")
    public @ResponseBody
    Device_group deviceGroup(@PathVariable String group_name){
        return device_groupRepo.findById(group_name).get();
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
