package com.GuilleApp.controller;


import com.GuilleApp.model.users.AppUser;
import com.GuilleApp.service.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void create (@RequestBody AppUser user){ userService.create(user);}

}
