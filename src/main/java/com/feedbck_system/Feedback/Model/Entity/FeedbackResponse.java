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
@Document(collection = "FeedbackResponses")
public class FeedbackResponse {
    @Id
    private String feedBackResponseId;
    private String adminId;
    private String responseText;
}
