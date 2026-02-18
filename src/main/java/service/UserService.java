package service;

import data.DataClass;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import repository.UserRepository;

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
