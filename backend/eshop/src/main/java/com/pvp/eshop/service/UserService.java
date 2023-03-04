package com.pvp.eshop.service;

import com.pvp.eshop.model.User;
import com.pvp.eshop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User user){
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhone(user.getPhone());
        return userRepository.save(newUser);
    }

    public boolean existsUser(long id) {
        return userRepository.existsById(id);
    }

    public User updateUser(Long id, User user){
        User userFromDb = userRepository.findById(id).get();
        userFromDb.setUsername(user.getUsername());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setPassword(user.getPassword());
        userFromDb.setPhone(user.getPhone());
        return userRepository.save(userFromDb);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
