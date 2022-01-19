package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.File;
import org.springframework.stereotype.Service;

@Service
public class FileService extends BaseService {
    private final FileMapper fileMapper;
    private final UserMapper userMapper;

    public FileService(FileMapper fileMapper, UserMapper userMapper) {
        this.fileMapper = fileMapper;
        this.userMapper = userMapper;
    }

    public String[] getFilesForUser(String userName) {
        return fileMapper.getFilesForUser(userName);
    }

    public void uploadFile(File file){
        file.setUserId(this.getUser(file.getLoggedInUser()).getUserId());
        fileMapper.insertFile(file);
    }

    public File getFile(String fileName, String userName) {
        return fileMapper.getFile(fileName, userName);
    }

    public void deleteFile(String fileName) {
        fileMapper.deleteFile(fileName);
    }
}
