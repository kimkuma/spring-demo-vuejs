package com.example.demo.api;

import com.example.demo.bean.CurrentUser;
import com.example.demo.bean.State;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@RequestMapping("/api")
public class StateApi {

    @GetMapping("/state")
    public ResponseEntity<Object> state(@CurrentUser User currentUser) {
        State state= new State();

        if(currentUser != null) {
            state.setId(RequestContextHolder.currentRequestAttributes().getSessionId());
            state.setName(currentUser.getUsername());
        }
        return ResponseEntity.ok(state);
    }
}
