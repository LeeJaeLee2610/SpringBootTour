package com.example.hrmproject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrmproject.entity.FileInfo;
import com.example.hrmproject.services.FilesStorageService;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    FilesStorageService filesStorageService;

    @PostMapping("/upload")
    public ResponseEntity<FileInfo> fileUpload(@RequestParam("file") MultipartFile multipartFile){
        try {
            filesStorageService.save(multipartFile);
            String filename = multipartFile.getOriginalFilename();
            return new ResponseEntity<>(new FileInfo("OK " + filename), HttpStatus.OK);
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(new FileInfo("Error"), HttpStatus.OK);
        }
    }

    @PostMapping("/uploads")
    public ResponseEntity<FileInfo> fileUploads(@RequestParam("files") MultipartFile[] multipartFiles){
        String mes = "";
        try {
            List<String> filenames = new ArrayList<>();
            Arrays.asList(multipartFiles).stream().forEach(file -> {
                filesStorageService.save(file);
                filenames.add(file.getOriginalFilename());
            });
            mes = "Uploaded the files successfully: " + filenames;
            return ResponseEntity.status(HttpStatus.OK).body(new FileInfo(mes));
        } catch (Exception e) {
            // TODO: handle exception
            mes = "Fail to upload files!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new FileInfo(mes));
        }
    }
}
