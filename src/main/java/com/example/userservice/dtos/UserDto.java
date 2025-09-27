package com.example.userservice.dtos;

import com.example.userservice.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto //You can also mention SignUpResponseDto instead of UserDto but I want to display name,email,pwd.
{
    private String name;
    private String email;
    private String password;

    public static UserDto from(User user)
    {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }
}
