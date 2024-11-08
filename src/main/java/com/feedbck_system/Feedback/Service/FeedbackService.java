package com.feedbck_system.Feedback.Service;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Entity.FeedbackResponse;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;

import java.util.List;

public interface FeedbackService {
    FeedBack submitFeedback(FeedbackRequest feedbackRequest);

    List<FeedBack> getAllFeedback();

    List<FeedBack> getFeedbackByStudentId(String studentId);


    FeedBack respondToFeedback(String feedbackId, FeedbackResponse response);
}
