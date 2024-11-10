package com.feedbck_system.Feedback.Model.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackRequest {

    private String userId;
    private String courseId;
    private String instructor;
    private int rating;
    private String comments;

}

