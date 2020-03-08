package com.example.demo.controller;

import com.example.demo.bean.CurrentUser;
import com.example.demo.bean.State;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @CurrentUser User currentUser) {
        State state= new State();

        if(currentUser != null) {
            state.setId(RequestContextHolder.currentRequestAttributes().getSessionId());
            state.setName(currentUser.getUsername());
        }

        model.addAttribute("state", state);
        model.addAttribute("entryJS", "/dist/index.js");
        return "index";
    }
}
