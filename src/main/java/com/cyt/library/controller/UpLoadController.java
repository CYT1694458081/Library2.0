package com.cyt.library.controller;


import com.cyt.library.domain.Res;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
//实现文件上传
@RestController
public class UpLoadController {
    @RequestMapping("public/fileUpload")
    public Res  fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()){
            return new Res(Res.ERROR,"图片为空",null);
        }else {
            //获取文件字节数组
            // 文件名
            String fileName = file.getOriginalFilename();
            // 后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 上传后的路径
//            String filePath = "D://img//";
            String filePath = "D://App//apache-tomcat-8.5.0//webapps//upload//";
            // 新文件名
            fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String img = "http://localhost:8083/upload/"+fileName;
            return new Res(Res.SUCCESS,"图片地址",img);
        }
    }

}
