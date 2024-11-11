package com.feedbck_system.Feedback.Model.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RequestParam;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "FeedbackResponses")
public class FeedbackResponse {

    private String adminId;
    private String feedbackId;
    private String responseText;
}
