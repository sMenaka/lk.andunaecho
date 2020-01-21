package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.Temp_schedule;
import lk.andunaechomedia.repositories.Temp_scheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class Temp_scheduleController {

    @Autowired
    Temp_scheduleRepo temp_scheduleRepo;

    @RequestMapping(method = RequestMethod.POST, path = "/upload/temp_schedule")
    public String temp_schedule_upload(@RequestParam MultipartFile temp_schedule_file, @RequestParam String temp_id, String version){
        Temp_schedule temp_schedule = new Temp_schedule();
        temp_schedule.setTemp_id(temp_id);
        temp_schedule.setVersion(version);
        String temp_name = StringUtils.cleanPath(temp_schedule_file.getOriginalFilename());
        Path path = Paths.get("/home/lapaty/Desktop/video/schedule/temp/"+temp_id+" "+version);
        try {
            Files.copy(temp_schedule_file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        temp_scheduleRepo.save(temp_schedule);
        return "Temp schedule upload Successfully...!";
    }
}
