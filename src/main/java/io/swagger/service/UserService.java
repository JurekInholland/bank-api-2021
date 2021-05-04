package io.swagger.service;

import io.swagger.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService
{
    User addUser(User user);
    List<User> getUsers();
}
