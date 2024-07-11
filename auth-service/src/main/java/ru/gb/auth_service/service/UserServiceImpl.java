package ru.gb.auth_service.service;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.gb.auth_service.exception.UserAlreadyExistsException;
import ru.gb.auth_service.exception.UserNotFoundException;
import ru.gb.auth_service.model.User;
import ru.gb.auth_service.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User saveUser(User user) {
        userRepository.findByUsername(user.getUsername())
                .ifPresent(existingUser -> {
                    throw new UserAlreadyExistsException("User with username " + user.getUsername() + " already exists");
                });
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with username " + username + " not found"));
    }

}