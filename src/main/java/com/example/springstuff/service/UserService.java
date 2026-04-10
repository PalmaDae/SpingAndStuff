package com.example.springstuff.service;

import com.example.springstuff.entity.UserEntity;
import com.example.springstuff.entity.UserRole;
import com.example.springstuff.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    public boolean createUser(UserEntity user) {
        if (userRepository.findByLogin(user.getLogin()) != null) {
            return false;
        }

        user.setRole(UserRole.USER);
        user.setHash_pass(passwordEncoder.encode(user.getHash_pass()));

        userRepository.saveUser(user);
        return true;
    }


}
