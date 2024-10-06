package com.sushant.userservice.controllers;

import com.sushant.userservice.dtos.UserDto;
import com.sushant.userservice.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class Validation {

    public Validation() {

    }

    /*@PostMapping()
    public ResponseEntity<UserDto> validateUser(@PathVariable("token") String token) {
        //Assuming token is valid for all cases
        //decoding token
        UserDto userDto = new UserDto(new User());
        return new ResponseEntity<User>(userDto, HttpStatus.OK);
    }*/

}
