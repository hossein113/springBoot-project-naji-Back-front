package com.naji.signup.project.controller;

import com.naji.signup.project.resource.UserResources;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserResources userResources;


    @PreAuthorize(value = "permitAll()")
    @GetMapping
    public ModelAndView getLogin(@RequestParam(required = false) String name) {
        ModelAndView modelAndView = new ModelAndView("loginPage");
        if (name != null) {
            modelAndView.addObject("message", "register successfully done!!");
        }
        return modelAndView;
    }

    @PreAuthorize(value = "permitAll()")
    @GetMapping("/sign-up")
    public ModelAndView getSignUpPage() {
        ModelAndView modelAndView = new ModelAndView("signUp3");
        return modelAndView;
    }


}
