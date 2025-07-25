package com.verinite.assetmanagementtool.model;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

public class JwtResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;
    @Getter
    private final T data;

    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
        this.data = null;
    }

    public JwtResponse(String token, T data) {
        this.jwtToken = token;
        this.data = data;
    }

}