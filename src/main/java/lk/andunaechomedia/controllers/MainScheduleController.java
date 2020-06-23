package lk.andunaechomedia.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.HashSet;
import java.util.Optional;

import lk.andunaechomedia.dtos.GetVersionDto;
import lk.andunaechomedia.dtos.SaveScheduleDto;
import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.File;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.models.MainSchedulePlayFile;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.FileRepo;

import lk.andunaechomedia.repositories.MainSchedulePlayFileRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import lk.andunaechomedia.services.MainScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainScheduleController {
    @Autowired
    MainScheduleRepo mainScheduleRepo;


    @Autowired
    DeviceGroupRepo groupRepo;
    @Autowired
    FileRepo fileRepo;

    @Autowired
    MainScheduleService scheduleService;

    @Autowired
    MainSchedulePlayFileRepo mainSchedulePlayFileRepo;



    @RequestMapping(method = {RequestMethod.POST}, path = {"/add/main_schedule"})
    public HttpEntity<SaveScheduleDto> mainScheduleUpload(@RequestBody SaveScheduleDto main_schedule) {
        return new ResponseEntity(scheduleService.save(main_schedule), HttpStatus.CREATED);
    }

    @RequestMapping(method = {RequestMethod.POST}, path = {"/add/main_schedule/videos/{groupid}"})
    public String addVideo(@RequestBody ArrayList<HashMap<String, String>> videoId, @PathVariable String groupid) {
        String result = null;

        DeviceGroup group = groupRepo.getOne(groupid);
        MainSchedule mainSchedule = group.getMainSchedule();
        mainSchedulePlayFileRepo.deleteByMainSchedule(mainSchedule.getScheduleId());



        try {
            videoId.forEach((item) -> {
                File file = fileRepo.getOne(item.get("id"));
                mainSchedule.getMainSchedulePlayFile().add(new MainSchedulePlayFile(mainSchedule, file, Integer.parseInt(item.get("point"))));
                fileRepo.save(file);
                mainScheduleRepo.save(mainSchedule);

            });
            result = "Successfully added main Schedule to " + group.getGroupName() + "group";
        } catch (Exception e) {
            System.out.println(e);
            result = "Oops..! \nSomething have error";
        }

        return result;
    }

    @RequestMapping(method = {RequestMethod.POST}, value = {"/add/file/{fid}/{mid}"})
    @ResponseBody
    public String addFile(@RequestParam String fid, @RequestParam String mid) {
        MainSchedulePlayFile mSchFile = new MainSchedulePlayFile();
        MainSchedule m = (MainSchedule) this.mainScheduleRepo.findById(mid).get();
        File file = (File) this.fileRepo.findById(fid).get();
        mSchFile.setMainSchedule(m);
        mSchFile.setFile(file);
        mSchFile.setPlayPoint(1);
        m.getMainSchedulePlayFile().add(mSchFile);
        this.fileRepo.save(file);
        this.mainScheduleRepo.save(m);
        System.out.println(mSchFile.getMainSchedule().getScheduleId() + mSchFile.getFile().getFile_id());
        return "dsgsdfgfdsgrgsdfgsdg";
    }

    @RequestMapping(method = {RequestMethod.GET}, value = {"/get/main_schedule/{id}"})
    @ResponseBody
    public Optional<MainSchedule> getSchedule(@PathVariable String id) {
        System.out.println(id);
        return this.mainScheduleRepo.findById(id);
    }
    @GetMapping("/get/version/{deviceId}")
    public HttpEntity<GetVersionDto> getMainScheduleVersion(@PathVariable String deviceId){
       return new  ResponseEntity(scheduleService.getCurrentVersion(deviceId),HttpStatus.ACCEPTED);
    }
}
