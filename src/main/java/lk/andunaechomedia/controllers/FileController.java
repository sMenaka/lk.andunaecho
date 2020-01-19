package lk.andunaechomedia.controllers;

import lk.andunaechomedia.fileExpesion.FileStorageExecption;
import lk.andunaechomedia.repositories.FileRepo;
import lk.andunaechomedia.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {
    @Autowired
    FileRepo fileRepo;
    @Autowired
    FileService fileService;

    @RequestMapping(method = RequestMethod.POST,value = "/file/upload")
    public String fileUpload(@RequestParam MultipartFile file){


            fileService.storeFile(file);






        return "ok";

    }

}
