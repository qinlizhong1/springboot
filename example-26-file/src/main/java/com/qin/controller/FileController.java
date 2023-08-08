package com.qin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
    @Value("${uploadFilePath}")
    private String uploadFilePath;

    @RequestMapping("/upload")
    public String test1(@RequestParam("file") MultipartFile file) throws IOException {
        String realPath =uploadFilePath;
        File newFile = new File(realPath);

        if (!newFile.exists()){
            newFile.mkdirs();
        }

        //上传
        file.transferTo(new File(newFile, file.getOriginalFilename()));
        return file.getOriginalFilename() + "上传成功！";
    }

    @RequestMapping("/download")
    public String test2(){
        return "ok";
    }
}
