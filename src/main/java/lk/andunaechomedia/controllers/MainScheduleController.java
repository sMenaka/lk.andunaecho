package lk.andunaechomedia.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.Optional;

import lk.andunaechomedia.models.DeviceGroup;
import lk.andunaechomedia.models.File;
import lk.andunaechomedia.models.MainSchedule;
import lk.andunaechomedia.models.MainSchedulePlayFile;
import lk.andunaechomedia.repositories.DeviceGroupRepo;
import lk.andunaechomedia.repositories.FileRepo;
import lk.andunaechomedia.repositories.MainScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainScheduleController {
    @Autowired
    MainScheduleRepo mainScheduleRepo;
    @Autowired
    DeviceGroupRepo groupRepo;
    @Autowired
    FileRepo fileRepo;


    @RequestMapping(method = {RequestMethod.POST}, path = {"/add/main_schedule"})
    public String main_schedule_upload(@RequestBody MainSchedule main_schedule) {
        this.mainScheduleRepo.save(main_schedule);
        return "Main schedule Upload Successfully...!";
    }

    @RequestMapping(method = {RequestMethod.POST}, path = {"/add/main_schedule/videos/{groupid}"})
    public String addVideo(@RequestBody ArrayList<HashMap<String, String>> videoId, @PathVariable String groupid) {
        String result = null;

        DeviceGroup group = groupRepo.getOne(groupid);
        MainSchedule mainSchedule = group.getMainSchedule();


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
}
