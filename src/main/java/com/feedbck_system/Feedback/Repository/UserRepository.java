package com.feedbck_system.Feedback.Repository;

import com.feedbck_system.Feedback.Model.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    boolean existsByUsername(String username);
    boolean existsByPhone(String phone);
    User findByPhone(String phone);
}
