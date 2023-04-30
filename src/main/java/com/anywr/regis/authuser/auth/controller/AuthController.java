package com.anywr.regis.authuser.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anywr.regis.authuser.auth.dto.AuthLoginDto;
import com.anywr.regis.authuser.auth.dto.AuthRegisterDto;
import com.anywr.regis.authuser.auth.exception.AuthError;
import com.anywr.regis.authuser.auth.service.interfaces.AuthService;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService service;

  @PostMapping("/register")
  public ResponseEntity<?> register(@Valid @RequestBody AuthRegisterDto request) {
    if (service.existsByUsername(request.getUsername()).isPresent()) {
      return ResponseEntity
          .badRequest()
          .body(new AuthError("Le nom d'utilisateur est déjà pris!"));
    }
    return ResponseEntity.ok(service.register(request.toUser()));
  }

  @PostMapping("/login")
  public ResponseEntity<?> login(
      @Valid @RequestBody AuthLoginDto request) {
    try {
      return ResponseEntity.ok(service.login(request.toUser()));
    } catch (BadCredentialsException e) {
      return ResponseEntity
          .badRequest()
          .body(new AuthError("Les informations de connexion sont incorrectes."));

    }
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {
    service.refreshToken(request, response);
  }

}
