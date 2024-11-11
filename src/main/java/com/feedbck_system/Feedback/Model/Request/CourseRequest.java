package com.feedbck_system.Feedback.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    private String userId;
    private String courseName;
    private  String description;
    private  String instructor;
}
