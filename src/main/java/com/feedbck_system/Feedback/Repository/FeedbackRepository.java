package com.feedbck_system.Feedback.Repository;

import com.feedbck_system.Feedback.Model.Entity.FeedBack;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends MongoRepository<FeedBack,String> {

}
