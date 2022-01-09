package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String getChatPage(NoteForm noteForm, Model model) {
        model.addAttribute("notes", this.noteService.getNotes());
        return "note";
    }

    @PostMapping
    public String postChatMessage(Authentication authentication, NoteForm noteForm, Model model) {
        noteForm.setUserName(authentication.getName());

        this.noteService.addNote(noteForm);
        noteForm.setNoteTitle("");
        noteForm.setNoteDescription("");
        model.addAttribute("notes", this.noteService.getNotes());  //Make sure to ret only user notes...
        return "chat";
    }
}
