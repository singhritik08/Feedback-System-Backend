package com.feedbck_system.Feedback.Exception;


import org.springframework.context.ApplicationContextException;

public class FeedbackException extends ApplicationContextException {
    public FeedbackException(String message){
        super(message);
    }
}
