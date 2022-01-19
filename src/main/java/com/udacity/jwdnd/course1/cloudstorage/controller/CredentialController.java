package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.*;
import com.udacity.jwdnd.course1.cloudstorage.services.CredentialService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("credential")
public class CredentialController {

    private final CredentialService credentialService;

    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping
    public String updateCredential(
            Authentication authentication,
            @ModelAttribute("newCredential") CredentialForm newCredential, Model model) {

        Credential credential = new Credential();
        credential.setLoggedInUser(authentication.getName());//
        credential.setUserName(newCredential.getUserName());
        credential.setUrl(newCredential.getUrl());
        credential.setCredentialId(newCredential.getCredentialId());
        credential.setPassword(newCredential.getPassword());

        credentialService.editCredential(credential);
        model.addAttribute("result", "success");
        return "result";
    }

    @GetMapping(value = "/delete/{credentialId}")
    public String deleteCredential(@PathVariable Integer credentialId,
                                   Model model) {
        credentialService.deleteCredential(credentialId);
        model.addAttribute("result", "success");
        return "result";
    }
}
