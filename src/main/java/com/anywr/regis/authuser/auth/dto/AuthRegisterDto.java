package com.anywr.regis.authuser.auth.dto;

import org.hibernate.validator.constraints.Length;

import com.anywr.regis.authuser.user.entity.User;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class AuthRegisterDto {

    @NotEmpty(message = "Le nom d'utilisateur est requis.")
    private String username;

    @NotEmpty(message = "Veuillez sécuriser votre compte avec un mot de passe.")
    @Length(min = 8, message = "Votre mot de passe est faible, veuillez utiliser au minimun 8 caractères.")
    private String password;

    public User toUser() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }

}
