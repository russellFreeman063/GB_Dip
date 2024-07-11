package ru.gb.auth_service.service;

import ru.gb.auth_service.model.User;

public interface UserService {
    User saveUser(User user);
    User findByUsername(String username);
}
