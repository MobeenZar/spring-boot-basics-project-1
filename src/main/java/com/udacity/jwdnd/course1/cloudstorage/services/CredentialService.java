package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class CredentialService extends BaseService {
    //private final UserMapper userMapper;
    private final CredentialMapper credentialMapper;
    private final EncryptionService encryptionService;

    public CredentialService( CredentialMapper credentialMapper, EncryptionService encryptionService) {
        //this.userMapper = userMapper;
        this.credentialMapper = credentialMapper;
        this.encryptionService = encryptionService;
    }

    public Credential[] getCredentialsForUser(String userName) {
        return credentialMapper.getCredentialsForUser(userName);
    }

    public void updateCredential(Credential credential) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(credential.getPassword(), encodedKey);
        credential.setKey(encodedKey);
        credential.setPassword(encryptedPassword);
        System.out.println("Cred id is : " + credential.getCredentialId());
        if (credential.getCredentialId() == null) {
            this.createCredential(credential);
        } else {
            this.updateCredential22(credential);
        }
    }

    public void createCredential(Credential credential) {
        Integer userId = this.getUser(credential.getLoggedInUser()).getUserId();
        credential.setUserid(userId);
        credentialMapper.insertCredential(credential);
    }

    public void updateCredential22(Credential credential) {
        credentialMapper.updateCredential(credential);
    }

    public void deleteCredential(Integer noteId) {
        credentialMapper.deleteCredential(noteId);
    }
}
