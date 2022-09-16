package com.example.hrmproject.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FilesStorageServiceImpl implements FilesStorageService{
    private final Path root = Paths.get("uploads");

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        FileSystemUtils.deleteRecursively(root.toFile());
        // System.out.println(root.toFile());
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        try {
            Files.createDirectory(root);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public Resource load(String filename) {
        // TODO Auto-generated method stub
        try {
            Path path = root.resolve(filename);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }else{
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            // TODO: handle exception
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        // TODO Auto-generated method stub
        try {
            return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Could not load the files!");
        }
    }

    @Override
    public void save(MultipartFile file) {
        // TODO Auto-generated method stub
        try {
            String name = file.getOriginalFilename();
        // fullpath
            String randomID = UUID.randomUUID().toString();
            String res = randomID.concat("_" + name);
            String filePath = root + res;
            Files.copy(file.getInputStream(), this.root.resolve(filePath));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    
}
