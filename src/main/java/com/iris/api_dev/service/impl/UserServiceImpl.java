package com.iris.api_dev.service.impl;

import com.iris.api_dev.domain.model.User;
import com.iris.api_dev.domain.repository.UserRepository;
import com.iris.api_dev.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userTocreate) {
        if(userRepository.existsByAccountNumber(userTocreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists");
        }
        return userRepository.save(userTocreate);
    }
}
