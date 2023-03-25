package com.scryfall.scryfallback.auth.service;

import com.scryfall.scryfallback.auth.model.dto.AuthenticationResponse;
import com.scryfall.scryfallback.auth.model.dto.LoginRequest;
import com.scryfall.scryfallback.auth.model.dto.RegisterRequest;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(LoginRequest request);
}
