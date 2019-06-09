package com.api.healthelp.service;

import com.api.healthelp.model.security.UserCredentials;

public interface LoginService {
    boolean login(UserCredentials userCredentials);
}
