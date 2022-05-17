package com.example.getInLine.error;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BaseErrorController.class)
class BaseErrorControllerTest {

    private MockMvc mock;

    public BaseErrorControllerTest(@Autowired MockMvc mock) {
        this.mock = mock;
    }

    @DisplayName("[view][GET] 에러 페이지 -페이지없음")
    @Test
    void givenWrongURI_whenRequestingPage_thenReturns404ErrorPage() throws Exception {
        //Given

        //When & Then
        mock.perform(get("/wrong-uri"))
                .andExpect(status().isNotFound())    //-테스트시 예상되는값
                .andDo(print());

    }

}