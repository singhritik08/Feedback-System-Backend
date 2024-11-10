package com.feedbck_system.Feedback.Controller;

import com.feedbck_system.Feedback.Exception.FeedbackException;
import com.feedbck_system.Feedback.Model.Request.LoginRequest;
import com.feedbck_system.Feedback.Model.Request.UserRequest;
import com.feedbck_system.Feedback.Model.Entity.User;
import com.feedbck_system.Feedback.Service.UserService;
import com.feedbck_system.Feedback.base.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ApiResponse<User> signUp(@RequestBody UserRequest userRequest){
        return new ApiResponse<>(userService.signUp(userRequest), HttpStatus.ACCEPTED);
    }

    @PostMapping("/login")
    public User getUser(@RequestBody LoginRequest loginRequest) {
        return userService.getUser(loginRequest);
    }

    @GetMapping("/fetch/All/Users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/profile/by/phone")
    public User getUserProfile(@RequestParam String phone){
        return userService.getUserProfile(phone);
    }

    @GetMapping("get/UserRole/ById")
    public String getUserRoleById( @RequestParam String userId){
        return userService.getUserRoleById(userId);
    }



}
