package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.MainSchedule;

import lk.andunaechomedia.models.MainScheduleHasFile;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.FileRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
public class MainScheduleController {

    @Autowired
    MainScheduleRepo mainScheduleRepo;
    @Autowired
    DeviceGroupRepo groupRepo;
    @Autowired
    FileRepo fileRepo;

    @RequestMapping(method = RequestMethod.POST, path = "/add/main_schedule")
    public String main_schedule_upload( @RequestBody MainSchedule main_schedule){

        mainScheduleRepo.save(main_schedule);
        return "Main schedule Upload Successfully...!";
    }
    @RequestMapping(method = RequestMethod.POST,path ="/add/main_schedule/videos/{groupid}")
    public ArrayList addVideo(@RequestBody ArrayList<HashMap<String,String>> videoId, @PathVariable String groupid){
        DeviceGroup group=groupRepo.findById(groupid).get();
        MainSchedule mainSchedule=group.getMainSchedule();
        MainScheduleHasFile mainScheduleHasFile=new MainScheduleHasFile();
        ArrayList unavailable =new ArrayList<String>();
        Set<MainScheduleHasFile> schedules=new HashSet<MainScheduleHasFile>();
        videoId.forEach((file)-> {

            if(fileRepo.existsById(file.get("id"))){
                mainScheduleHasFile.setMainSchedule(mainSchedule);
                mainScheduleHasFile.setFile(fileRepo.findById(file.get("id")).get());
                mainScheduleHasFile.setPlayPoint(Integer.parseInt(file.get("point")));
                schedules.add(mainScheduleHasFile);
            }else {
                unavailable.add(file.get("id"));
            }
        });
        if(!schedules.isEmpty()){

            mainSchedule.setMainScheduleHasFile(schedules);
            mainScheduleRepo.save(mainSchedule);
        }
        return unavailable;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/get/main_schedule/{id}")
    public @ResponseBody Optional<MainSchedule> getSchedule(@PathVariable  String id){
        System.out.println(id);
        return  mainScheduleRepo.findById(id);
    }
}
