package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.Main_schedule;
import lk.andunaechomedia.repositories.Main_scheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collections;
import java.util.Optional;

@RestController
public class Main_scheduleController {

    @Autowired
    Main_scheduleRepo main_scheduleRepo;

    @RequestMapping(method = RequestMethod.POST, path = "/add/main_schedule")
    public String main_schedule_upload( @RequestBody Main_schedule main_schedule){


        main_scheduleRepo.save(main_schedule);
        return "Main schedule Upload Successfully...!";
    }
    @RequestMapping(method = RequestMethod.GET,value = "/get/main_schedule/{id}")
    public @ResponseBody Optional<Main_schedule> getSchedule(@PathVariable  String id){
        System.out.println(id);
        return  main_scheduleRepo.findById(id);
    }
}
