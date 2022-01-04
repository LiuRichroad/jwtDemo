package com.example.jwtimpl.api;

import com.example.jwtimpl.entity.User;
import com.example.jwtimpl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class userController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/login")
    public Map<String,String> login(@RequestParam User user){
        String s = userService.loginAndGetToken(user);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","true");
        map.put("token",s);
        return map;
    }


}
