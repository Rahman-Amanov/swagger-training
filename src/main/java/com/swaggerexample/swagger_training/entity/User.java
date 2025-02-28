package com.swaggerexample.swagger_training.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private  String name;
    private String lastName;
    private int age;

    public static List<User> dummyUsers(){
        User u1=new User("Ahmet","Ak",25);
        User u2=new User("Ayse","Mavi",32);
        User u3=new User("Mehmet","Sari",15);
        return List.of(u1,u2,u3);

    }

}










