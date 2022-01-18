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
//    public Credential(Integer credentialId, String url, String userName, String key, String password, Integer userid) {
//        this.credentialId = credentialId;
//        this.url = url;
//        this.userName = userName;
//        this.key = key;
//        this.password = password;
//        this.userid = userid;
//    }

    public Credential(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }
}
