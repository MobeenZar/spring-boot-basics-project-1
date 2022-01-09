package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM Notes")
    List<Note> getAllNotes();

    @Insert("INSERT INTO MESSAGES (notetitle, notedescription, userid) VALUES(#{username}, #{messageText}), #{userId}")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int addNote(Note note);

}
