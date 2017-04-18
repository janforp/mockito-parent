package com.janita.mock.one.service;

import com.janita.mock.one.bean.User;

import java.util.*;

/**
 * Created by Janita on 2017-04-18 20:04
 */
public class UserService {

    private static Map<String,User> userMap = new HashMap<>();

    public User createUser(User user){

        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        userMap.put(userId,user);
        return user;
    }

    public User deleteUser(String userId){
        User user = userMap.get(userId);
        userMap.remove(userId);
        return user;
    }

    public User updateUser(String userId,User user){
        user.setUserId(userId);
        userMap.put(userId,user);
        return user;
    }

    public User findById(String userId){
        return userMap.get(userId);
    }

    public List<User> getAllUser(){
        Collection<User> users = userMap.values();
        List<User> usersList = new ArrayList<>();
        usersList.addAll(users);

        return usersList;
    }
}
