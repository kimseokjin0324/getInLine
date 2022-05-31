package com.example.getInLine.controller.api;

import com.example.getInLine.dto.APIDataResponse;
import com.example.getInLine.dto.AdminRequest;
import com.example.getInLine.dto.LoginRequest;
import org.springframework.web.bind.annotation.*;

/**
 * Spring Data REST 로 API 를 만들어서 당장 필요가 없어진 컨트롤러.
 * 우선 deprecated 하고, 향후 사용 방안을 고민해 본다.
 * 필요에 따라서는 다시 살릴 수도 있음
 *
 * @deprecated 0.1.2
 */
@Deprecated
//@RequestMapping("/api")
//@RestController
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
