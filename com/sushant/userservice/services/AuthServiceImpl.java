package com.sushant.userservice.services;

import com.sushant.userservice.dtos.UserDto;
import com.sushant.userservice.kafka.ProducerMessage;
import com.sushant.userservice.models.User;
import com.sushant.userservice.models.WelcomeEmail;
import com.sushant.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.sushant.userservice.UserConstants.*;

@Service
public class AuthServiceImpl implements com.sushant.userservice.services.AuthService {

    private UserRepository userRepository;

    @Autowired
    private ProducerMessage producerMessage;

    public AuthServiceImpl(UserRepository userRepository, ProducerMessage producerMessage) {
        this.userRepository = userRepository;
        this.producerMessage = producerMessage;
    }

    @Override
    public UserDto signUp(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword((password));
        User savedUser = userRepository.save(user);
        UserDto userDto = UserDto.from(savedUser);
        // send welcome email using Kafka topic
        WelcomeEmail emailData = new WelcomeEmail(email, EMAIL_WELCOME_SUBJECT, EMAIL_WELCOME_BODY+ LocalDateTime.now());
        producerMessage.sendMessage(EMAIL_TOPIC_NAME, email, emailData);
        return userDto;
    }

    /*public ResponseEntity<UserDto> login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if(userOptional.isEmpty()) {
            return null;
        }
        User user = userOptional.get();
    }*/
}
