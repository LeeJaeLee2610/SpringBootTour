package com.example.hrmproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrmproject.entity.File;
import com.example.hrmproject.services.FileService;

@RestController
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;
    @Value("${project.image}")
    private String path;
    @PostMapping("/upload")
    public ResponseEntity<File> fileUpload(@RequestParam("image") MultipartFile image){
        String filename = this.fileService.uploadFile(path, image);
        return new ResponseEntity<>(new File(filename, "OK"), HttpStatus.OK);
    }
}
