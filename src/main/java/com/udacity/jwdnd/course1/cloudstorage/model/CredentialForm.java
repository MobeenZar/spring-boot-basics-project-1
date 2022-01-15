package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.Data;

@Data
public class CredentialForm {
    private String url;
    private String userName;
    private Integer credentialId;
    private String password;
}
