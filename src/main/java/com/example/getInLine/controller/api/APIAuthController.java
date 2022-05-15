package com.example.getInLine.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class APIAuthController {

    //-이 return 값을 뷰 resolving 하는게 아니고
    //이 값을 그대로 return 해주는게 @RestController가 가진
    //@ResponseBody 의 특징이다.
    @GetMapping("/sign-up")
    public String signUp() {
        return "done.";
    }
    @GetMapping("/login")
    public String login() {
        return "done.";
    }

}
