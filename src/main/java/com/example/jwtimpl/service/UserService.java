package com.example.jwtimpl.service;

import com.example.jwtimpl.entity.User;
import com.example.jwtimpl.utils.JWTUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    public String loginAndGetToken(User user){
        Map<String,String> map = new HashMap<>();
        map.put("id",user.getId().toString());
        map.put("name",user.getName());
        return JWTUtil.getToken(map);
    }
}
