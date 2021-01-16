package cn.river.transfer.controller;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    public String fileUplaod(@RequestParam(value = "file") MultipartFile[] files) throws IOException {
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            byte[] bytes = file.getBytes();
            String pathName = "D:\\pictures\\" + file.getOriginalFilename();
            File destFile = new File(pathName);
            FileCopyUtils.copy(bytes, destFile);
        }
        return "success";
    }
}