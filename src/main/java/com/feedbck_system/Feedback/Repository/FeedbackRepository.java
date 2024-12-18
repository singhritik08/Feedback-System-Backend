package com.feedbck_system.Feedback.Repository;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeedbackRepository extends MongoRepository<FeedBack,String> {

    FeedBack findByFeedbackId(String feedbackId);

    List<FeedBack> getFeedbackByUserId(String userId);

    List<FeedBack> findByCourseId(String courseId);
}
