package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("Creating MessageService bean");
    }

    public List<Note> getNotes() {
        return this.noteMapper.getAllNotes();
    }

    public void addNote(NoteForm noteForm) {
        Note note = new Note();
        note.setUserName(noteForm.getUserName());
        note.setNoteTitle(noteForm.getNoteTitle());
        note.setNoteDescription(noteForm.getNoteDescription());

        noteMapper.addNote(note);
    }
}
