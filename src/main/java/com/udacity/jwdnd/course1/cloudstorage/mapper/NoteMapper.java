package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    @Select("SELECT * FROM Notes where userid = #{userId}")
    List<Note> getAllNotes(Integer userId);

    @Insert("INSERT INTO MESSAGES (notetitle, notedescription, userid) VALUES(#{username}, #{messageText}), #{userId}")
    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int addNote(Note note);

//    //========
//
//    @Select("SELECT * FROM NOTES")
//    Note[] getNoteListings();

    @Select("SELECT * FROM NOTES WHERE noteid = #{noteId}")
    Note getNote(Integer noteId);

    @Delete("DELETE FROM NOTES WHERE noteid = #{noteId}")
    void deleteNote(Integer noteId);

    @Update("UPDATE NOTES SET notetitle = #{title}, notedescription = #{description} WHERE noteid = #{noteId}")
    void updateNote(Integer noteId, String title, String description);

}
