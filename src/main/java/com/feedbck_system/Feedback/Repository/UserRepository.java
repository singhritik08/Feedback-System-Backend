package com.feedbck_system.Feedback.Repository;

import com.feedbck_system.Feedback.Model.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    boolean existsByUsername(String username);
    boolean existsByPhone(String phone);
    User findByPhone(String phone);

    User findByUserId(String userId);

    boolean findByPassword(String password);
}
