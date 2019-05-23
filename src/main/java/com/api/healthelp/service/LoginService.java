package com.api.healthelp.service;

import com.api.healthelp.model.UserCredentials;

import java.util.List;

public interface LoginService {
    List<String> login(UserCredentials userCredentials);
}
