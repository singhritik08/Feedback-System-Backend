package com.feedbck_system.Feedback.Service;

import com.feedbck_system.Feedback.Model.Entity.Course;
import com.feedbck_system.Feedback.Model.Request.CourseRequest;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course createCourse(CourseRequest courseRequest);

    List<Course> findAll();

    Optional<Course> getCourseById(String id);
}
