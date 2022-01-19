package com.udacity.jwdnd.course1.cloudstorage.model;

import lombok.Data;

@Data
public class Credential {
    private Integer credentialId;
    private String url;
    private String userName;
    private String key;
    private String password;
    private Integer userid;
    private String loggedInUser;

    public Credential(){}

    public Credential(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
}
