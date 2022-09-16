package com.example.hrmproject.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String uploadFile(String path, MultipartFile multipartFile);

}
