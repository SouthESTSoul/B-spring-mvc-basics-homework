package com.thoughtworks.capacity.gtb.mvc.service.impl;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.exception.PasswordException;
import com.thoughtworks.capacity.gtb.mvc.exception.RepeatNameException;
import com.thoughtworks.capacity.gtb.mvc.exception.UserNotExistException;
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
       user.setId(userDB.size()+1);
       userDB.put(user.getName(),user);
    }

    @Override
    public UserDto login(String name, String password) {
        UserDto user = userDB.get(name);
        if(user==null){
            throw new UserNotExistException("User is not exist");
        }
        if(!user.getPassword().equals(password)){
            throw new PasswordException("Incorrect account and password");
        }
        return user;
    }
}
