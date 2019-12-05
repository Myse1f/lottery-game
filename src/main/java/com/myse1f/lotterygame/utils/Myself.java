package com.myse1f.lotterygame.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;

@Component
public class Myself {
    private static String privateKey;

    @Value("${myself.private_key}")
    public void setPrivateKey(String privateKey) {
        Myself.privateKey = privateKey;
    }

    private static Credentials credentials;
    private static String address;

    public static Credentials getCredentials() {
        if (credentials == null) {
            credentials = Credentials.create(privateKey);
        }
        return credentials;
    }

    public static String getAddress() {
        if (address == null) {
            address = getCredentials().getAddress();
        }
        return address;
    }
}
