package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NoteService extends BaseService {
    private NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public List<Note> getNotesForUser(String userName) {
        return this.noteMapper.getNotesForUser(userName);
    }

    public void update(Note note) {
        if (note.getNoteId() == null) {
            this.addNote(note);
        } else {
            this.updateNote(note);
        }
    }

    public void addNote(Note note) {
        //Note note = new Note(null, note.getNoteTitle(), noteForm.getNoteDescription(),  );
        note.setUserId(this.getUser(note.getLoggedInUser()).getUserId());
        noteMapper.addNote(note);
    }

    public void deleteNote(Integer noteId) {
        noteMapper.deleteNote(noteId);
    }

    public void updateNote(Note note) {
        noteMapper.updateNote(note.getNoteId(), note.getNoteTitle(), note.getNoteDescription());
    }
}
