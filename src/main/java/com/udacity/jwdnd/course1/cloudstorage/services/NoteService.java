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

    public List<Note> getNotes(String userName) {
        return this.noteMapper.getAllNotes(userName);
    }

    public void addNote(NoteForm noteForm) {
        Note note = new Note(null, noteForm.getNoteTitle(), noteForm.getNoteDescription(), noteForm.getUserId() );
        noteMapper.addNote(note);
    }

//    public Note getNote(Integer noteId) {
//        return noteMapper.getNote(noteId);
//    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }

    public void updateNote(Integer noteId, String title, String description) {
        noteMapper.updateNote(noteId, title, description);
    }
}
