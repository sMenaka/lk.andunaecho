package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.Device;
import lk.andunaechomedia.repositories.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {
    @Autowired
    private DeviceRepo deviceRepo;
    @RequestMapping("/Home")
    public @ResponseBody Iterable<Device> welcome(){
    return  deviceRepo.findAll();
    }


}
