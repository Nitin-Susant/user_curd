package com.user.Service;

import com.user.Entity.User;
import com.user.Excep.UserNotFound;
import com.user.Reposiraty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
         User user = userRepository.findById(id).get();

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        Optional<User> userById = getUserById(id);
        if (userById.isPresent())
            userRepository.deleteById(id);
        else
            throw new UserNotFound("user not found by id ="+id);
    }

}

