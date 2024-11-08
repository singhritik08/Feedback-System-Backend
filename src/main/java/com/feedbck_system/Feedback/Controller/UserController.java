package com.feedbck_system.Feedback.Controller;

import com.feedbck_system.Feedback.Model.Request.LoginRequest;
import com.feedbck_system.Feedback.Model.Request.UserRequest;
import com.feedbck_system.Feedback.Model.Entity.User;
import com.feedbck_system.Feedback.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signUp(@RequestBody UserRequest userRequest) {
        return userService.signUp(userRequest);
    }
    @PostMapping("/login")
    public boolean getUser(@RequestBody LoginRequest loginRequest) {
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
