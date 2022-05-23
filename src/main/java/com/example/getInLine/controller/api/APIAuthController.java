package com.example.getInLine.controller.api;

import com.example.getInLine.dto.APIDataResponse;
import com.example.getInLine.dto.AdminRequest;
import com.example.getInLine.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
public class APIAuthController {

    //-이 return 값을 뷰 resolving 하는게 아니고
    //이 값을 그대로 return 해주는게 @RestController가 가진
    //@ResponseBody 의 특징이다.

    @PostMapping("/sign-up")
    public APIDataResponse<String> signUp(@RequestBody AdminRequest adminRequest) {
        return APIDataResponse.empty();
    }

    @PostMapping("/login")
    public APIDataResponse<String> login(@RequestBody LoginRequest loginRequest) {
        return APIDataResponse.empty();
    }
}
