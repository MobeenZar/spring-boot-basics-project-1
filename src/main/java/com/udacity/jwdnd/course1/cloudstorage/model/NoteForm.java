package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.Data;

@Data
public class NoteForm {
    private String noteTitle;
    private String noteDescription;
    private Integer noteId;
    private Integer userId;
}
