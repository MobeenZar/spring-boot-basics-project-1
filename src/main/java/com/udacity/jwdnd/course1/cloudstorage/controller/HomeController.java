package com.udacity.jwdnd.course1.cloudstorage.controller;


import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    private NoteService noteService;
    private Authentication authentication;
    public HomeController(NoteService noteService) {
        this.noteService = noteService;
    }



    @GetMapping
    public String getNotes(Authentication authentication, Model model) {
        System.out.println("User name is :" + authentication.getName());
        model.addAttribute("notes", this.noteService.getNotes()); //authentication.getName()
        return "homeOrig";
    }

//    @PostMapping
//    public String postChatMessage(Authentication authentication, ChatForm chatForm, Model model) {
//        chatForm.setUsername(authentication.getName());
//        this.messageService.addMessage(chatForm);
//        chatForm.setMessageText("");
//        model.addAttribute("chatMessages", this.messageService.getChatMessages());
//        return "chat";
//    }
//
//    @ModelAttribute("allMessageTypes")
//    public String[] allMessageTypes () {
//        return new String[] { "Say", "Shout", "Whisper" };
//    }
//

}

