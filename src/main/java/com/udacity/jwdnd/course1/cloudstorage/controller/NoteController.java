package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.*;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/note")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public String updateNote(
            Authentication authentication,
            @ModelAttribute("noteForm") NoteForm noteForm,
            Model model) {

         Note note = new Note();
         note.setNoteId(noteForm.getNoteId());
         note.setUserId(noteForm.getUserId());
         note.setNoteTitle(noteForm.getNoteTitle());
         note.setNoteDescription(noteForm.getNoteDescription());
         note.setLoggedInUser(authentication.getName());

         noteService.update(note);
         model.addAttribute("result", "success");
         return "result";
    }

    @GetMapping(value = "/delete/{noteId}")
    public String deleteNote(
            @PathVariable Integer noteId,
            Model model) {
        noteService.deleteNote(noteId);
        model.addAttribute("result", "success");
        return "result";
    }
}
