package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;
    //private final UserService userService;

    public FileController(
            FileService fileService) {
        this.fileService = fileService;
        //this.userService = userService;
    }

    @PostMapping
    public String uploadFile(Authentication authentication,
                          @ModelAttribute("newFile") FileForm newFile,
                          Model model) throws IOException {
        String fileName = newFile.getFile().getOriginalFilename();
        if(newFile.getFile().isEmpty()){
            model.addAttribute("result", "error")
                 .addAttribute("message", "Please select a file to upload!");
            return "result";
        }

        if(ifFileExists(fileName, authentication.getName())){
            model.addAttribute("result", "error")
                    .addAttribute("message", fileName + " already exists.");
            return "result";
        }

        File file = new File();
        file.setLoggedInUser(authentication.getName());
        file.setFileName(newFile.getFile().getOriginalFilename());
        file.setContentType(newFile.getFile().getContentType());
        file.setFileSize(String.valueOf(newFile.getFile().getSize()));
        file.setFileData(newFile.getFile().getBytes());

        fileService.uploadFile(file);
        model.addAttribute("result", "success");
        return "result";
    }

    @GetMapping("/get-file/{fileName}")
    @ResponseBody
    public ResponseEntity<byte[]> serveFile(Authentication authentication, @PathVariable String fileName) {
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.add("Content-Disposition", "attachment; filename=" + fileName);
        return new ResponseEntity<byte[]>(fileService.getFile(fileName, authentication.getName()).getFileData(), respHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/delete-file/{fileName}")
    public String deleteFile(@PathVariable String fileName,
                             @ModelAttribute("newFile") FileForm newFile,
                              Model model) {
        fileService.deleteFile(fileName);
        model.addAttribute("result", "success");
        return "result";
    }

    private  boolean ifFileExists(String fileName, String userName) {
        File file = fileService.getFile(fileName , userName);
        if (file == null) return false;
        else return true;
    }
}

