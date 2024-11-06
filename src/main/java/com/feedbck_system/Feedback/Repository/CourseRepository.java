package com.feedbck_system.Feedback.Repository;

import com.feedbck_system.Feedback.Model.Entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends MongoRepository<Course,String> {

    boolean existsByCourseName(String courseName);
}
