package com.thoughtworks.capacity.gtb.mvc.service.impl;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class UserServiceImpl implements UserService {
    public static CopyOnWriteArrayList<UserDto> userDB= new CopyOnWriteArrayList();
    @Override
    public void register(UserDto userDto) {
        if(!userDB.contains(userDto)){
        userDB.add(userDto);
        }
    }

    @Override
    public void login() {

    }
}
