package com.udacity.jwdnd.course1.cloudstorage.controller;


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



    @GetMapping
    public String getChatPage(Model model) {
        //model.addAttribute("chatMessages", this.messageService.getChatMessages());
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
