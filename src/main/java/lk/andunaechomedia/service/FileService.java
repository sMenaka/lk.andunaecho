package lk.andunaechomedia.service;

import lk.andunaechomedia.fileExpesion.FileStorageExecption;
import lk.andunaechomedia.models.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {

    public final Path fileStoreLocation;

    @Autowired
    public FileService(File file)  {
        this.fileStoreLocation= Paths.get(file.getFile_path()).toAbsolutePath().normalize();

        try{
            Files.createDirectories(this.fileStoreLocation);
        }
        catch (Exception e){
            try {
                throw  new FileStorageExecption("--------Create directories exception-------");
            } catch (FileStorageExecption fileStorageExecption) {
                fileStorageExecption.printStackTrace();
            }
        }
    }


    public String storeFile(MultipartFile file) {
        String fileName= StringUtils.cleanPath(file.getOriginalFilename());
        try {
            Path targetPath=this.fileStoreLocation.resolve(fileName);
            Files.copy(file.getInputStream(),targetPath, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        }
        catch (Exception e){
            try {
                throw new  FileStorageExecption("---------Cann't copy file----");
            } catch (FileStorageExecption fileStorageExecption) {
                fileStorageExecption.printStackTrace();
            }
            return fileName;
        }
    }
}
