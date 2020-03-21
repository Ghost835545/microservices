package org.backend.service;

import org.backend.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Page<User> findAll(Pageable pageable);
    User createUser(User user);
    List<User> getAll();
    void deleteAll();
    void deleteById(String id);
    boolean signIn(String password, String login);
    List<User> findByPassword(String password);
    //List<User> findByName(String name);
    List<User> findByLogin(String login);
   Optional<User> findById(String id);

}
