package com.sushant.userservice.services;

import com.sushant.userservice.dtos.UserDto;

public interface AuthService {

    UserDto signUp(String email, String password);
}
