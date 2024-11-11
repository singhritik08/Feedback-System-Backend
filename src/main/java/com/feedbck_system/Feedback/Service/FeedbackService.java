package com.feedbck_system.Feedback.Service;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Entity.FeedbackResponse;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;

import java.util.List;

public interface FeedbackService {
    FeedBack submitFeedback(FeedbackRequest feedbackRequest);

    List<FeedBack> getAllFeedback();



    FeedBack respondToFeedback(FeedbackResponse response);

    List<FeedBack> getFeedbackByUserId(String userId);

    List<FeedBack> getFeedbackByCourseId(String courseId);

    boolean getIfResponded(String feedbackId);
}
