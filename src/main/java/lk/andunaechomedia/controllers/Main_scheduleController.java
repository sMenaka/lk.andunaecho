package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.Main_schedule;
import lk.andunaechomedia.repositories.Main_scheduleRepo;
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
public class Main_scheduleController {

    @Autowired
    Main_scheduleRepo main_scheduleRepo;

    @RequestMapping(method = RequestMethod.POST, path = "/upload/main_schedule")
    public String main_schedule_upload(@RequestParam MultipartFile main_schedule_file, @RequestParam String schedule_id, @RequestParam String version){
        Main_schedule main_schedule = new Main_schedule();
        main_schedule.setSchedule_id(schedule_id);
        main_schedule.setVersion(version);
        String main_name = StringUtils.cleanPath(main_schedule_file.getOriginalFilename());
        Path path = Paths.get("/home/lapaty/Desktop/video/schedule/main/"+schedule_id+" "+version);
        try {
            Files.copy(main_schedule_file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        main_scheduleRepo.save(main_schedule);
        return "Main schedule Upload Successfully...!";
    }
}
