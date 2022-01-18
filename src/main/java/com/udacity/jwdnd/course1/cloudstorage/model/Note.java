package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.Data;

@Data
public class Note {
    private Integer noteId;
    private String noteTitle;
    private String noteDescription;
    private Integer userId;
    private String loggedInUser;

    public Note(){}
//    public Note(Integer noteId, String noteTitle, String noteDescription, Integer userId) {
//        this.noteId = noteId;
//        this.noteTitle = noteTitle;
//        this.noteDescription = noteDescription;
//        this.userId = userId;
//    }
    public Note(String noteTitle, String noteDescription) {
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
    }
}