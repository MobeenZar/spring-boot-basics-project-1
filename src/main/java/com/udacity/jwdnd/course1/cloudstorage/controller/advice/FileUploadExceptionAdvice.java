package com.udacity.jwdnd.course1.cloudstorage.controller.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class FileUploadExceptionAdvice {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(
            MaxUploadSizeExceededException exc,
            Model model) {

        model.addAttribute("result", "error")
        .addAttribute("message", "File is larger than allowed size. Max limit is 2MB" );

        return "result";
    }
}
