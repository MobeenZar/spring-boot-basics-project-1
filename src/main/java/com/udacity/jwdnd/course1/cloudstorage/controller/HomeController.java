package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialForm;
import com.udacity.jwdnd.course1.cloudstorage.model.FileForm;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final FileService fileService;
    private final NoteService noteService;
    private final CredentialService credentialService;
    private final EncryptionService encryptionService;

    public HomeController(
            FileService fileService, NoteService noteService,
            CredentialService credentialService, EncryptionService encryptionService) {
        this.fileService = fileService;
        this.noteService = noteService;
        this.credentialService = credentialService;
        this.encryptionService = encryptionService;
    }

    @GetMapping
    public String getHome(
            Authentication authentication,
            @ModelAttribute("newFile") FileForm newFile,
            @ModelAttribute("newNote") NoteForm newNote,
            @ModelAttribute("newCredential") CredentialForm newCredential,
            Model model) {
        model.addAttribute("notes", this.noteService.getNotesForUser(authentication.getName()));
        model.addAttribute("files", this.fileService.getFilesForUser(authentication.getName()));
        model.addAttribute("credentials", credentialService.getCredentialsForUser(authentication.getName()));
        model.addAttribute("encryptionService", encryptionService);

        return "home";
    }
}

