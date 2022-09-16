package com.example.hrmproject.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceimpl implements FileService{

    @Override
    public String uploadFile(String path, MultipartFile multipartFile) {
        // TODO Auto-generated method stub
        // filename
        String name = multipartFile.getOriginalFilename();
        // fullpath
        String randomID = UUID.randomUUID().toString();
        String res_name = randomID.concat("_" + name);
        String filePath = path + File.separator + res_name;
        // create folder if not created
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        // file copy
        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(filePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return name;
    }
}
