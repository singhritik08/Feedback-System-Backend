package com.feedbck_system.Feedback.Controller;

import com.feedbck_system.Feedback.Model.Entity.Course;
import com.feedbck_system.Feedback.Model.Request.CourseRequest;
import com.feedbck_system.Feedback.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;




    @PostMapping("/create/course")
    public Course createCourse(@RequestBody CourseRequest courseRequest){
        return courseService.createCourse(courseRequest);
    }

    @GetMapping("/get/all/Course")
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/course/by/id")
    public Optional<Course> getCourseById(@RequestParam String id) {
        return courseService.getCourseById(id);
    }

}
