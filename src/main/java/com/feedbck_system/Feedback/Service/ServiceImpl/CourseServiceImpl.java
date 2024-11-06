package com.feedbck_system.Feedback.Service.ServiceImpl;

import com.feedbck_system.Feedback.Model.Entity.Course;
import com.feedbck_system.Feedback.Model.Request.CourseRequest;
import com.feedbck_system.Feedback.Repository.CourseRepository;
import com.feedbck_system.Feedback.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    //todo Only admin can create Course

    @Override
    public Course createCourse(CourseRequest courseRequest) {
        if(!courseRepository.existsByCourseName(courseRequest.getCourseName())){
            Course newCourse = new Course();
            newCourse.setCourseName(courseRequest.getCourseName());
            newCourse.setDescription(courseRequest.getDescription());
            newCourse.setInstructors(courseRequest.getInstructors());
            return courseRepository.save(newCourse);
        }else {
            // return null if course already exists
            return new Course();
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
