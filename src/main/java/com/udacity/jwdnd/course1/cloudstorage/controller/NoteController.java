package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.*;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @PostMapping("add-note")
    public String newNote(
         Authentication authentication, @ModelAttribute("newNote") NoteForm newNote, Model model) {
         Integer noteId = newNote.getNoteId();
         //System.out.println("New noteid is " + noteId);

        if (noteId == null) {
            User user = userService.getUser(authentication.getName());
            newNote.setUserId(user.getUserId());
            noteService.addNote(newNote);
        } else {
            noteService.updateNote(noteId, newNote.getNoteTitle(), newNote.getNoteDescription());
        }
        model.addAttribute("result", "success");
        return "result";
    }

    @GetMapping(value = "/delete-note/{noteId}/{userId}")
    public String deleteNote(
            Authentication authentication,
            @PathVariable Integer noteId,
            @PathVariable Integer userId,
            @ModelAttribute("newNote") NoteForm newNote,
            //@ModelAttribute("newFile") FileForm newFile,
            //@ModelAttribute("newCredential") CredentialForm newCredential,
            Model model) {
        noteService.deleteNote(noteId);
//      System.out.println("user id: " + userId + " noteId: " + noteId);
        model.addAttribute("result", "success");

        return "result";
    }
}
