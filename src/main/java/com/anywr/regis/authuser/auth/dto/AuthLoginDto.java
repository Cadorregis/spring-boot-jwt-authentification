package com.anywr.regis.authuser.auth.dto;

import com.anywr.regis.authuser.user.entity.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthLoginDto {

    @NotEmpty(message = "Le nom d'utilisateur est requis.")
    private String username;

    @NotEmpty(message = "Le mot de passe est requis.")
    private String password;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
