package lk.andunaechomedia.controllers;

import jdk.nashorn.internal.runtime.options.Option;
import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DeviceController {

    @Autowired
    private DeviceRepo deviceRepo;

    @RequestMapping("/get/device/all")
    public @ResponseBody Iterable<Device> getAll(){

        return  deviceRepo.findAll();
    }

    @RequestMapping("/get/device/{id}")
    public @ResponseBody
    Optional<Device> getOne(@PathVariable String id){
        return deviceRepo.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add/device")
    public @ResponseBody String addDevice(@RequestBody Device device){
        System.out.println(device.getPublish_date());
        deviceRepo.save(device);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/device")
    public @ResponseBody String updateDevice(@RequestBody Device device){
       Device updateDevice=deviceRepo.findById(device.getDevice_id()).get();
       updateDevice.setPublish_date(device.getPublish_date());
       updateDevice.setCustomer_name(device.getCustomer_name());
       updateDevice.setTel_number(device.getTel_number());
       updateDevice.setDevice_address(device.getDevice_address());
       updateDevice.setEnd_point(device.getEnd_point());
       updateDevice.setStart_point(device.getStart_point());
       try {
           deviceRepo.save(updateDevice);
           return "upload successful";
       }
       catch (Exception e){
           return "upload error";
       }
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/device/{device_id}")
    public String deleteDevice(@PathVariable String device_id){

        try {
            deviceRepo.deleteById(device_id);
            return "Device Deleted Successfully";
        }
        catch (Exception e){
            return "Device Not Found...!";
        }
    }



}
