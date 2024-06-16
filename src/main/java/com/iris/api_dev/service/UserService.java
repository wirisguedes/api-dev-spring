package com.iris.api_dev.service;

import com.iris.api_dev.domain.model.User;

public interface UserService {


    User findById(Long id);

    User create(User userTocreate);
}
