package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;
    private final UserService userService;

    public FileController(
            FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @PostMapping
    public String newFile(Authentication authentication,
                          @ModelAttribute("newFile") FileForm newFile,
                          Model model) throws IOException {
        String userName = authentication.getName();
        User user = userService.getUser(userName);
        Integer userId = user.getUserId();

        MultipartFile multipartFile = newFile.getFile();
        String fileName = multipartFile.getOriginalFilename();

        //Check for duplicate file name
        String[] fileListings = fileService.getFileListings(userId);
        for (String fileListing: fileListings) {
            if (fileListing.equals(fileName)) {
                model.addAttribute("result", "error");
                model.addAttribute("message", "You have tried to add a duplicate file.");
                return "result";
            }
        }
        fileService.addFile(multipartFile, userName);
        model.addAttribute("result", "success");
        return "result";
    }

    @GetMapping("/get-file/{fileName}")
    @ResponseBody
    public ResponseEntity<byte[]> serveFile(@PathVariable String fileName) {
        HttpHeaders respHeaders = new HttpHeaders();
        respHeaders.add("Content-Disposition", "attachment; filename=" + fileName);
        return new ResponseEntity<byte[]>(fileService.getFile(fileName).getFileData(), respHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "/delete-file/{fileName}")
    public String deleteFile(@PathVariable String fileName,
                             @ModelAttribute("newFile") FileForm newFile,
                              Model model) {
        fileService.deleteFile(fileName);
        model.addAttribute("result", "success");
        return "result";
    }
}

