package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.apache.ibatis.annotations.*;

@Mapper
public interface FileMapper {

    @Select("SELECT filename FROM FILES WHERE userid = (SELECT userId FROM USERS WHERE username = #{userName})" )
    String[] getFilesForUser(String userName);

    @Select("SELECT * FROM FILES WHERE filename = #{fileName} and userid = (SELECT userId FROM USERS WHERE username = #{userName})")
    File getFile(String fileName, String userName);

//    @Select("SELECT * FROM FILES WHERE filename = #{fileName} and userid = (SELECT userId FROM USERS WHERE username = #{userName})")
//    File getFile(String fileName, String userName);

    @Insert("INSERT INTO FILES (filename, contenttype, filesize, userid, filedata) " +
            "VALUES(#{fileName}, #{contentType}, #{fileSize}, #{userId}, #{fileData})")
    @Options(useGeneratedKeys = true, keyProperty = "fileId")
    int insertFile(File file);

    @Delete("DELETE FROM FILES WHERE filename = #{fileName}")
    void deleteFile(String fileName);
}
