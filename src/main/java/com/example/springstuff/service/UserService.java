package com.example.springstuff.service;

import com.example.springstuff.entity.User;
import com.example.springstuff.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    //В UR по-хорошему сделать булевы и проверять их тут, но пока так будет
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.createUser(user);
    }

    public User getUser(Long id) {
        return userRepository.getUserById(id);
    }

    public void updateUser(Long id, String name) {
        userRepository.updateUser(id,name);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }
}
