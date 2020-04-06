package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceRepo;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DeviceController  {

    @Autowired
    private DeviceRepo deviceRepo;
    @Autowired
    private DeviceGroupRepo device_groupRepo;

    @RequestMapping(method=RequestMethod.GET,value = "/get/device/all")
    public @ResponseBody Iterable<Device> getAll(){

        return  deviceRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET,value="/get/device/{id}")
    public @ResponseBody
    Device getOne(@PathVariable String id){
        Device device=deviceRepo.findById(id).get();
        return device;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add/device")
    public @ResponseBody String addDevice( @RequestBody Device device){
        System.out.println(device_groupRepo.findById(device.getDeviceGroup().getGroupId()).get().getGroupName());
        device.setDeviceGroup(device_groupRepo.findById(device.getDeviceGroup().getGroupId()).get());
        deviceRepo.save(device);
        return "Saved";
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/device")
    public @ResponseBody String updateDevice(@RequestBody Device device){
        Device updateDevice=deviceRepo.findById(device.getDeviceId()).get();
        updateDevice.setPublishDate(device.getPublishDate());
        updateDevice.setCustomerName(device.getCustomerName());
        updateDevice.setTelNumber(device.getTelNumber());
        updateDevice.setDeviceAddress(device.getDeviceAddress());
        updateDevice.setEndPoint(device.getEndPoint());
        updateDevice.setStartPoint(device.getStartPoint());
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