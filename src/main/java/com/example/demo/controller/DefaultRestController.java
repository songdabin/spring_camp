package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@RequestMapping("/api")
@RestController
public class DefaultRestController {
    @PostMapping("/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
        String filename = file.getOriginalFilename();
        System.out.println(filename);

        String filePath = "uploadfiles/";
        File newfile = new File(filePath);
        if (!newfile.exists()) {
            newfile.mkdirs();
        }

        Date date = new Date();
        String temp_date = date.getTime() + "";
        String finalName = filePath + temp_date + "_" + filename;
        FileCopyUtils.copy(file.getBytes(), new File(finalName));

        return ResponseEntity.status(HttpStatus.OK).body(temp_date + "_" + filename);
    }
}
