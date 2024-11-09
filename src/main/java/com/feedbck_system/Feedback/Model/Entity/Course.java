package com.feedbck_system.Feedback.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("Courses")

public class Course {
    @Id
    private String courseId;
    private String courseName;
    private  String description;
    private  String instructors;


}
