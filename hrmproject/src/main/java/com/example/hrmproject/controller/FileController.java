package com.example.hrmproject.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrmproject.entity.FileInfo;
import com.example.hrmproject.services.FileService;
import com.example.hrmproject.services.FilesStorageService;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Autowired
    FilesStorageService filesStorageService;
    @Value("${project.upload}")
    private String path;
    @PostMapping("/upload")
    public ResponseEntity<FileInfo> fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String filename = this.fileService.uploadFile(path, multipartFile);
        return new ResponseEntity<>(new FileInfo(filename, "OK"), HttpStatus.OK);
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
