package com.feedbck_system.Feedback.Service.ServiceImpl;

import com.feedbck_system.Feedback.Controller.UserController;
import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Entity.FeedbackResponse;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;
import com.feedbck_system.Feedback.Repository.FeedbackRepository;
import com.feedbck_system.Feedback.Service.FeedbackService;
import com.feedbck_system.Feedback.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private UserService userService;


    @Override
    public FeedBack submitFeedback(FeedbackRequest feedbackRequest) {
        if (!feedbackRepository.existsById(feedbackRequest.getStudentId())){
            if (!feedbackRepository.existsById(feedbackRequest.getCourseId())){
                FeedBack feedBack = new FeedBack();
                feedBack.setCourseId(feedbackRequest.getCourseId());
                feedBack.setStudentId(feedbackRequest.getStudentId());
                feedBack.setInstructor(feedbackRequest.getInstructor());
                feedBack.setRating(feedbackRequest.getRating());
                feedBack.setComments(feedbackRequest.getComments());
                return feedbackRepository.save(feedBack);
            }
            else {
                return new FeedBack();
            }
        }else {
            return new FeedBack();
        }
    }


    @Override
    public List<FeedBack> getAllFeedback() {
      return feedbackRepository.findAll();
    }

    @Override
    public List<FeedBack> getFeedbackByStudentId(String studentId) {
        return feedbackRepository.findByStudentId(studentId);
    }


    @Override
    public FeedBack respondToFeedback(String feedbackId, FeedbackResponse response) {
        String Role= userService.getUserRoleById(response.getAdminId());
        if (!"admin".equals(Role)) {
            throw new RuntimeException("Only admins can respond to feedback.");
        }

        FeedBack feedback = feedbackRepository.findByFeedbackId(feedbackId);
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
