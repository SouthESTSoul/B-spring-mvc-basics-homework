package com.thoughtworks.capacity.gtb.mvc.service.impl;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.exception.RepeatNameException;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {
    public static ConcurrentHashMap<String,UserDto> userDB= new ConcurrentHashMap();
    @Override
    public void register(UserDto user) {
       if(userDB.get(user.getName())!=null){
           throw new RepeatNameException("The name already exists");
       }
       userDB.put(user.getName(),user);
    }

    @Override
    public void login() {

    }
}
