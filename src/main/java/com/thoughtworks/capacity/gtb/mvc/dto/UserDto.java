package com.thoughtworks.capacity.gtb.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDto {
    int id;
    @NotEmpty
    @Pattern(regexp ="[0-9A-Za-z_]{3,10}",message = "The username should be consisted of numbers, letters and underscores,and the length of name must be between 5-12")
    private String username;
    @NotEmpty
    @Size(min =5 ,max =12 ,message="Password length must be between 5-12" )
    private String password;
    @Email(message = "Not a legal email address")
    private String email;
}
