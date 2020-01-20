package lk.andunaechomedia.controllers;

import org.springframework.util.StringUtils;

import lk.andunaechomedia.fileExpesion.FileStorageExecption;
import lk.andunaechomedia.repositories.FileRepo;
import lk.andunaechomedia.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

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
public class FileController {
@RequestMapping(value = "/upload",method = RequestMethod.POST)
public String fileUpload(@RequestParam MultipartFile file){
    String filename= StringUtils.cleanPath(file.getOriginalFilename());
    Path path= Paths.get("/home/hp/Desktop/video"+filename);
    try {
        Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
    }

    catch (IOException e){
        System.out.println("sfdsagdgffgdsgsdgsdgfsfvfsdfsd");
    }

return "ok";
}

}


