package org.backend.service.impl;

import org.backend.entity.User;
import org.backend.repository.UserRepository;
import org.backend.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }
    /*@Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }*/

    @Override
    public List<User> findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public List<User> findByPassword(String password) {
        return userRepository.findByPassword(password);
    }

    @Override
    public boolean signIn(String password, String login) {
        boolean flag = false;
        List<User> users = new ArrayList<>(userRepository.findAll());
        for (int i = 0; i < users.size(); i++) {
            if ((users.get(i).getLogin().equals(login)) && (users.get(i).getPassword().equals(password))) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
