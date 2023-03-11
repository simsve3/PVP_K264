package com.pvp.eshop.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.pvp.eshop.model.User;
import com.pvp.eshop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        String hash = "";
        try {
            hash = toHexString(getSHA(user.getUsername() + ":" + user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        newUser.setPassword(hash);
        newUser.setPhone(user.getPhone());
        return userRepository.save(newUser);
    }

    public boolean existsUser(long id) {
        return userRepository.existsById(id);
    }
    public User userByUsername(String username) {
        return userRepository.userByUsername(username);
    }

    public User updateUser(Long id, User user) {
        User userFromDb = userRepository.findById(id).get();
        userFromDb.setUsername(user.getUsername());
        userFromDb.setEmail(user.getEmail());
        String hash = "";
        try {
            hash = toHexString(getSHA(user.getUsername() + ":" + user.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        userFromDb.setPassword(hash);
        userFromDb.setPhone(user.getPhone());
        return userRepository.save(userFromDb);
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    public static String toHexString(byte[] hash) {
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while (hexString.length() < 64) {
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }

    public boolean comparePasswords(String username, String password) {
        String hash = "";
        try {
            hash = toHexString(getSHA(username + ":" + password));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Exception thrown for incorrect algorithm: " + e);
        }
        User userFromDb = userByUsername(username);
        return hash.equals(userFromDb.getPassword());
    }
}
