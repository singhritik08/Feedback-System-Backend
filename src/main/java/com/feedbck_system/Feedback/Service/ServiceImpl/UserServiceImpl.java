package com.feedbck_system.Feedback.Service.ServiceImpl;

import com.feedbck_system.Feedback.Model.Request.LoginRequest;
import com.feedbck_system.Feedback.Model.Request.UserRequest;
import com.feedbck_system.Feedback.Model.Entity.User;
import com.feedbck_system.Feedback.Repository.UserRepository;
import com.feedbck_system.Feedback.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User signUp(UserRequest userRequest) {
        if (!userRepository.existsByPhone(userRequest.getPhone())){
            if (!userRepository.existsByUsername(userRequest.getUsername())) {
                User user = new User();
                user.setRole(userRequest.getRole());
                user.setUsername(userRequest.getUsername());
                user.setPassword(userRequest.getPassword());
                user.setPhone(userRequest.getPhone());
                return userRepository.save(user);
            } else {
                // return when already phoneNumber exists.
                return new User();
            }
        } else {
            /// return when username already exists.
            return new User();
        }
    }

    @Override
    public User getUser(LoginRequest loginRequest) {
            User user = userRepository.findByPhone(loginRequest.getPhone());
            if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
                return user;
            }
            return new User();
        }


    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserProfile(String phone) {
        User user = userRepository.findByPhone(phone);
        if (user != null) {
            String id = user.getUserId();
            return userRepository.findByUserId(id);

        } else {
            return new User();
        }
    }

    @Override
    public String getUserRoleById(String userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        return user.getRole();
        User user = userRepository.findByUserId(userId);
        if (user == null){
            return null;
        }else {
            return user.getRole();
        }
    }



}
