package com.telran.org.security;

import com.telran.org.security.model.JwtAuthenticationResponse;
import com.telran.org.security.model.SignInRequest;

public interface AuthenticationService {

    JwtAuthenticationResponse authenticate(SignInRequest request);
}
