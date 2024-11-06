package com.feedbck_system.Feedback.Controller;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;
import com.feedbck_system.Feedback.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit/feedback")
    public FeedBack submitFeedback(@RequestBody FeedbackRequest feedbackRequest){
        return feedbackService.submitFeedback(feedbackRequest);
    }
    @GetMapping("/get/all/feedback")
    public List<FeedBack> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
    @GetMapping("get/feedback/by/student/id")
    public Optional<FeedBack> getFeedbackByStudentId(@RequestParam String studentId){
        return feedbackService.getFeedbackByStudentId(studentId);
    }
}
