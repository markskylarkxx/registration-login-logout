package com.spring_boot_registration.dto;

import com.spring_boot_registration.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationDto {

    private  String firstName;
    private  String lastName;
    private String password;
    private  String email;


}
