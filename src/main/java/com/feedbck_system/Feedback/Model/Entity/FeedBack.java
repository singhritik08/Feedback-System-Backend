package com.feedbck_system.Feedback.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Feedback")

public class FeedBack {
    @Id
    private String feedbackId;
    private String userId;
    private String courseId;
    private String instructor;
    private int rating;
    private String comments;
    private FeedbackResponse feedbackResponse;
}
