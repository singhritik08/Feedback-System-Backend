package com.feedbck_system.Feedback.Service;

import com.feedbck_system.Feedback.Model.Request.LoginRequest;
import com.feedbck_system.Feedback.Model.Request.UserRequest;
import com.feedbck_system.Feedback.Model.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User signUp(UserRequest userRequest);

    boolean getUser(LoginRequest loginRequest);

    List<User> findAllUsers();

    User getUserProfile(String phone);

    String getUserRoleById(String userId);
}
