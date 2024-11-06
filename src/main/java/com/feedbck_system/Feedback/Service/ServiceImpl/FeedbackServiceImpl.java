package com.feedbck_system.Feedback.Service.ServiceImpl;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;
import com.feedbck_system.Feedback.Repository.FeedbackRepository;
import com.feedbck_system.Feedback.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

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
    public Optional<FeedBack> getFeedbackByStudentId(String studentId) {
        if (!feedbackRepository.existsById(studentId)){
            return feedbackRepository.findById(studentId);
        }
        return Optional.empty();
    }
}
