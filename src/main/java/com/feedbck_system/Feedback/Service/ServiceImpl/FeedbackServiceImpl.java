package com.feedbck_system.Feedback.Service.ServiceImpl;

import com.feedbck_system.Feedback.Exception.FeedbackException;
import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Entity.FeedbackResponse;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;
import com.feedbck_system.Feedback.Repository.FeedbackRepository;
import com.feedbck_system.Feedback.Service.FeedbackService;
import com.feedbck_system.Feedback.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private UserService userService;


    @Override
    public FeedBack submitFeedback(FeedbackRequest feedbackRequest) {
        if (feedbackRequest.getRating() < 1 || feedbackRequest.getRating() > 5) {
            throw new FeedbackException("Rating must be between 1 and 5.");
        }
        if (feedbackRequest.getComments() == null || feedbackRequest.getComments().trim().isEmpty()) {
            throw new FeedbackException("Comments cannot be empty.");
        }

        FeedBack feedBack = new FeedBack();
        feedBack.setCourseId(feedbackRequest.getCourseId());
        feedBack.setUserId(feedbackRequest.getUserId());
        feedBack.setInstructor(feedbackRequest.getInstructor());
        feedBack.setRating(feedbackRequest.getRating());
        feedBack.setComments(feedbackRequest.getComments());
        try {
            return feedbackRepository.save(feedBack);
        } catch (Exception e) {
            throw new FeedbackException("error: Feedback not saved");
        }
    }

    @Override
    public List<FeedBack> getAllFeedback() {
      return feedbackRepository.findAll();
    }

    @Override
    public List<FeedBack> getFeedbackByUserId(String userId) {
        return feedbackRepository.getFeedbackByUserId(userId);
    }

    @Override
    public List<FeedBack> getFeedbackByCourseId(String courseId) {
        List<FeedBack> feedbackList = feedbackRepository.findByCourseId(courseId);

        if (feedbackList != null && !feedbackList.isEmpty()) {
            return feedbackList;
        } else {

            return new ArrayList<>();
        }
    }

    @Override
    public boolean getIfResponded(String feedbackId) {
        FeedBack feedBack = feedbackRepository.findByFeedbackId(feedbackId);
        if (feedBack != null && feedBack.getFeedbackResponse() != null) {
            return true;
        }
        return false;
    }


    @Override
    public FeedBack respondToFeedback(FeedbackResponse response) {
        FeedBack feedback = feedbackRepository.findByFeedbackId(response.getFeedbackId());
    if (feedback != null){
        feedback.setFeedbackResponse(response);
        feedbackRepository.save(feedback);
        return feedback;
    }
         else {
            throw new RuntimeException("Feedback not found");
        }
    }



}
