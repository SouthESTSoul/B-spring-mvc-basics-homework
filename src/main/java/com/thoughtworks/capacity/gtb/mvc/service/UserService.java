package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;

public interface UserService {
    void register(UserDto user);

    UserDto login(String name, String password);
}
