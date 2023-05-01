package com.naji.signup.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/userw")
@RequiredArgsConstructor
public class UserwController {

    @PreAuthorize(value = "permitAll()")
    @GetMapping("/sign-up")
    public ModelAndView getSignUpPage() {
        ModelAndView modelAndView = new ModelAndView("one");
        return modelAndView;
    }
}
