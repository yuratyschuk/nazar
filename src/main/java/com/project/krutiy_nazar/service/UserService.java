package com.project.krutiy_nazar.service;

import com.project.krutiy_nazar.model.user.User;
import com.project.krutiy_nazar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }
}