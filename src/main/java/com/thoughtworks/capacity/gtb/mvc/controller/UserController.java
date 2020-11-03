package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.dto.UserDto;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@AllArgsConstructor
@Validated
public class UserController {

    UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid  UserDto user) {
        userService.register(user);
    }

    @GetMapping("/login")
    public ResponseEntity<UserDto> login(@RequestParam @Pattern(regexp ="[0-9A-Za-z_]{3,10}",message = "The name should be consisted of numbers, letters and underscores,and the length of name must be between 5-12")
                                                     String name,
                                         @RequestParam @Size(min =5 ,max =12 ,message="Password length must be between 5-12" )
                                                 String password){
        UserDto user = userService.login(name, password);
       return ResponseEntity.ok().body(user);
    }
}
