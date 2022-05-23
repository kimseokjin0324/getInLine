package com.example.getInLine.dto;

import com.example.getInLine.constant.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class APIDataResponseTest {

    @DisplayName("[Api] 문자열 데이터가 주어지면, 표준 성공 응답을 생성한다.")
    @Test
    void givenStringData_whenCreatingResponse_thenReturnsSuccessfulResponse() {

        //Given
        String data = "test Data";
        //When
        APIDataResponse<String> response = APIDataResponse.of(data);
        //Then
        //assertJ는 data를 chaining 방식으로 테스트해볼수있다.
        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", data);

    }

    @DisplayName("[Api] 데이터가 없으면, 비어 있는 표준 성공 응답을 생성한다.")
    @Test
    void givenNothing_whenCreatingResponse_thenReturnsEmptySuccessfulResponse() {

        //Given

        //When
        APIDataResponse<String> response = APIDataResponse.empty();
        //Then
        //assertJ는 data를 chaining 방식으로 테스트해볼수있다.
        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", null);

    }
}