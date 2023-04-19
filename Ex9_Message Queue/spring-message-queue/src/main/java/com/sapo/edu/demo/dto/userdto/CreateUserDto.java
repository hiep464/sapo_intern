package com.sapo.edu.demo.dto.userdto;

import com.sapo.edu.demo.entities.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateUserDto {

        @NotBlank(message = "username is mandatory")
        private String username;

        @NotBlank(message = "password is mandatory")
        private String password;

        public CreateUserDto(String username, String password) {
                this.username = username;
                this.password = password;
        }

        public User GenerateUser(){
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                return user;
        }
}
