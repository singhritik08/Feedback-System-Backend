package com.feedbck_system.Feedback.Model.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    @NotBlank
    String username;
    @NotBlank
    String phone;
    @NotBlank
    String role;
    @NotBlank
    String password;
}
