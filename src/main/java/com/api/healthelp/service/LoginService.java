package com.api.healthelp.service;

import com.api.healthelp.model.UserCredentials;

public interface LoginService {
    String login(UserCredentials userCredentials);
}
