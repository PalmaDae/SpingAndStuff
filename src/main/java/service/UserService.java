package service;

import data.DataClass;
import entity.User;
import repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    //В UR по-хорошему сделать булевы и проверять их тут, но пока так будет

    public UserService() {
        this.userRepository = new UserRepository(DataClass.getConnection());
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
