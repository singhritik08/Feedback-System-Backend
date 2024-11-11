package com.feedbck_system.Feedback.Service.ServiceImpl;

import com.feedbck_system.Feedback.Exception.FeedbackException;
import com.feedbck_system.Feedback.Model.Entity.Course;
import com.feedbck_system.Feedback.Model.Request.CourseRequest;
import com.feedbck_system.Feedback.Repository.CourseRepository;
import com.feedbck_system.Feedback.Service.CourseService;
import com.feedbck_system.Feedback.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserService userService;



    @Override
    public Course createCourse(CourseRequest courseRequest) {
        if ("admin".equals(userService.getUserRoleById(courseRequest.getUserId()))) {
            if (!courseRepository.existsByCourseName(courseRequest.getCourseName())) {
                Course newCourse = new Course();
                newCourse.setCourseName(courseRequest.getCourseName());
                newCourse.setDescription(courseRequest.getDescription());
                newCourse.setInstructor(courseRequest.getInstructor());
                return courseRepository.save(newCourse);
            }else {
                return new Course();
            }
        }else {
            throw new FeedbackException("Only Admin is authorized to Add Course");
        }
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(String id) {
        Optional<Course> course = courseRepository.findById(id);
        if(course.isPresent()){
            return course;
        }
        return Optional.of(new Course());
    }

}
