package com.feedbck_system.Feedback.Controller;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import com.feedbck_system.Feedback.Model.Entity.FeedbackResponse;
import com.feedbck_system.Feedback.Model.Request.FeedbackRequest;
import com.feedbck_system.Feedback.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/feedback")
@CrossOrigin("*")

public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;



    @PostMapping("/submit/feedback")
    public FeedBack submitFeedback(@RequestBody FeedbackRequest feedbackRequest){
        return feedbackService.submitFeedback(feedbackRequest);
    }

    @GetMapping("get/feedback/by/student/id")
    public  List<FeedBack> getFeedbackByUserId(@RequestParam String userId){
        return feedbackService.getFeedbackByUserId(userId);
    }

    @PutMapping("respond/to/feedback")
    public FeedBack respondToFeedback(@RequestBody FeedbackResponse response) {
        return feedbackService.respondToFeedback(response);
    }

    @GetMapping("get/feedback/by/courseId")
    public List<FeedBack> getFeedbackByCourseId(@RequestParam String courseId){
        return feedbackService.getFeedbackByCourseId(courseId);
    }

    @GetMapping("/get/all/feedback")
    public List<FeedBack> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("get/if/responded")
    public boolean getIfResponded(@RequestParam String feedbackId){
        return feedbackService.getIfResponded(feedbackId);
    }
}
