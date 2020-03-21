package org.backend.repository;


import org.backend.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
        //List<User> findByName(String name);
        List<User> findByLogin(String login);
        List<User> findByPassword(String password);
}
