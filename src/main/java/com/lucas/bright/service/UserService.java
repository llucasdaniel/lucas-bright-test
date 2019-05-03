package com.lucas.bright.service;

import com.lucas.bright.model.User;
import com.lucas.bright.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lucas Daniel
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserById(int user) {
        return userRepository.findById(user);
    }

    public Optional<User> findUserByName(User user) {
        return userRepository.findByName(user.getName());
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
