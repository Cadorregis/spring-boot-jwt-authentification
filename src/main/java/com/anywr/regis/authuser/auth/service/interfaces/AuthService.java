package com.anywr.regis.authuser.auth.service.interfaces;

import java.io.IOException;
import java.util.Optional;

import com.anywr.regis.authuser.auth.dto.AuthResponse;
import com.anywr.regis.authuser.user.entity.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {

  public AuthResponse register(User request);

  public AuthResponse login(User request);
  
  public Optional<User> existsByUsername(String username);

  public void refreshToken(HttpServletRequest request,
      HttpServletResponse response) throws IOException;

}
