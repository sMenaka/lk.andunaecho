package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.MainScheduleHasFile;
import lk.andunaechomedia.repositories.DeviceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@RestController
public class RaspberryPIRequestController {
    @Autowired
    DeviceRepo deviceRepo;

    @RequestMapping(method = RequestMethod.GET,value = "/get/rapPI/schedule/{deviceId}")
    public HashMap<String,String> getSchedules(@PathVariable String deviceId){
        HashMap schedule=new HashMap<String,Integer>();

       Set<MainScheduleHasFile> mainScheduleHasFile=deviceRepo.findById(deviceId).get().getDeviceGroup().getMainSchedule().getMainScheduleHasFile();


       mainScheduleHasFile.forEach((schedules)->{
           String name=new File(schedules.getFile().getFile_path()).getName();
           ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/file/").path(name).toUriString();
           schedule.put("fileId",schedules.getFile().getFile_id());
           schedule.put("link",ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/file/").path(name).toUriString());
           schedule.put("playPoint",Integer.toString(schedules.getPlayPoint()));


       });



        return schedule;
    }

@RequestMapping(method = RequestMethod.GET,value = "/download/file/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
        Path path =Paths.get("/andunaEcho/files/").toAbsolutePath().normalize().resolve(fileName).normalize();
        Resource resource=null;
        String contentType=null;
        try {
            resource=new UrlResource(path.toUri());
            if(resource.exists()){
                contentType=request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            }
        }
        catch (MalformedURLException e){

        }
        catch (IOException ioE){

        }
         if(contentType==null){
             contentType="application/octet-stream" ;

         }


        return ResponseEntity.ok().
        contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename\""+resource.getFilename()+"\"")
                .body(resource);
    }

}
