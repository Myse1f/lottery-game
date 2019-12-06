package com.myse1f.lotterygame.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;

@Component
public class Myself {
    private String privateKey;
    private Credentials credentials;
    private String address;

    public Myself(@Value("${myself.private_key}")String privateKey) {
        this.privateKey = privateKey;
        credentials = Credentials.create(privateKey);
        address = getCredentials().getAddress();
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public String getAddress() {
        return address;
    }
}
