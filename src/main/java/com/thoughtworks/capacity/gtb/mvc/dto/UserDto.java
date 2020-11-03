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
    @NotEmpty
    @Pattern(regexp ="[0-9A-Za-z_]{3,10}")
    private String name;
    @NotEmpty
    @Size(min =5 ,max =12 )
    private String password;
    @Email
    private String email;
}
