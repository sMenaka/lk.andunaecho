package lk.andunaechomedia.controllers;

import lk.andunaechomedia.models.File;
import lk.andunaechomedia.repositories.FileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@RestController
public class FileController {
    @Autowired
    FileRepo repo;


@RequestMapping(value = "/upload",method = RequestMethod.POST)
public String fileUpload(@RequestParam MultipartFile file, @RequestParam String fileId){
    File saveFile=new File();
    saveFile.setFile_id(fileId);
    Path path=null;
    String filename= StringUtils.cleanPath(file.getOriginalFilename());
    if(!(new java.io.File(System.getProperty("user.home")+"/andunaEcho/files").exists())){
        new java.io.File(System.getProperty("user.home")+"/andunaEcho/files").mkdirs();
    }
    path=Paths.get(System.getProperty("user.home")+"/andunaEcho/files/"+filename);
    saveFile.setFile_path(path.toString());
    repo.save(saveFile);
    try {
        Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
    }

    catch (IOException e){
        System.out.println(e);
    }


return "ok";
}

}


