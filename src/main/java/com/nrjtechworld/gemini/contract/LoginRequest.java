package com.nrjtechworld.gemini.contract;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    private String UserName;
    private String Password;
}
