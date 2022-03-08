package com.bchernovol.blog1.controller;

import com.bchernovol.blog1.service.UserRepresentation;
import com.bchernovol.blog1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class LoginPageController {

    private final UserService userService;

    @Autowired
    public LoginPageController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/reg")
    public String RegisterPage(Model model){
        model.addAttribute("user", new UserRepresentation());
        return "reg";
    }
    @PostMapping("/reg")
     public String registerNewUser(@Valid UserRepresentation userRepresentation, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "reg";
        }
        if(!userRepresentation.getPassword().equals(userRepresentation.getRepeatPassword())){
            bindingResult.rejectValue("password","","Passwords do not match");
            return "reg";
        }
        userService.create(userRepresentation);
        return "redirect:/login";
     }
   }
