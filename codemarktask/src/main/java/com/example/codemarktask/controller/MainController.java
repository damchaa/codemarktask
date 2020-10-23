package com.example.codemarktask.controller;

import com.example.codemarktask.model.*;
import com.example.codemarktask.repo.RoleRepo;
import com.example.codemarktask.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RestController

public class MainController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @GetMapping("/userrole")
    public List<User> findAllUser(){


        return null;
    }

    @GetMapping("/user")
    public List<UserResponse> findAllWithoutRole(){
        List<UserResponse> list = new ArrayList<>();
        List<User> users = userRepo.findAll();
        for (User user: users){
            list.add(new UserResponse(user.getName(), user.getLogin(), user.getPassword()));
        }

        return list;
    }


    @PostMapping("/user/{login}/remove")
    public void removeUser(@PathVariable(value = "login") String login) {
        User user = userRepo.findByLogin(login);
        userRepo.delete(user);
        for (User user1: userRepo.findAll()){
            System.out.println(user1);
        }

    }
    @PostMapping ("/user/new")
    public SaveUserResponse addNewUser(@RequestBody User user){
        SaveUserResponse saveUserResponse = CheckerUser.checkCriteria(user);
        if (saveUserResponse.isSuccess()){
            userRepo.save(user);
        }

        return CheckerUser.checkCriteria(user);
    }

    @GetMapping("/user/{login}")
    public User getUserByName(@PathVariable(value = "login") String login){
        User user = userRepo.findByLogin(login);
        return user;

    }

    @PostMapping("/user/{login}/update")
    public SaveUserResponse updateUserByLogin(@PathVariable(value = "login") String login, @RequestBody User updateUser){
        SaveUserResponse saveUserResponse = CheckerUser.checkCriteria(updateUser);
        List<Role> roles = new ArrayList<>();
        Set<Role> setRole = new HashSet<>();
        System.out.println(updateUser);
        if (saveUserResponse.isSuccess()) {
            User user = userRepo.findByLogin(login);
            user.setLogin(updateUser.getLogin());
            user.setPassword(updateUser.getPassword());
            user.setName(updateUser.getName());
            for (Role role: updateUser.getRoles()){
                for (Role role1 : user.getRoles()){
                    if (!role.getId().equals(role1.getId())){
                        roles.add(role);
                    }
                    else{
                        if (role.getId().equals(role.getId())){
                            roles.add(role);
                        }
                    }

                }
            }
            setRole.addAll(roles);
            user.setRoles(setRole);
            userRepo.delete(userRepo.findByLogin(login));
            userRepo.save(user);
            return saveUserResponse;
        }
        else {
            return saveUserResponse;
        }

        

    }

}
