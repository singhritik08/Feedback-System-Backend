package com.feedbck_system.Feedback.Service;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;

import java.util.List;
import java.util.Optional;

public interface FeedbackService {
    FeedBack submitFeedback(FeedbackRequest feedbackRequest);

    List<FeedBack> getAllFeedback();

    Optional<FeedBack> getFeedbackByStudentId(String studentId);
}
