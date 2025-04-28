package com.pickgang.board.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pickgang.user.global.exception.error.ErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String code;
    private String message;
    private T data;

    private final static String SUCCESS_CODE = "SUCCESS";

    public static ApiResponse<Object> success(String message) {
        return ApiResponse.builder()
                .code(SUCCESS_CODE)
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code(SUCCESS_CODE)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .code(SUCCESS_CODE)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> success(T data, String message, HttpStatus httpStatus) {
        return ApiResponse.<T>builder()
                .code(SUCCESS_CODE)
                .message(message)
                .data(data)
                .build();
    }

    public static <T> ApiResponse<T> fail(ErrorCode error) {
        return ApiResponse.<T>builder()
                .code(error.getCode())
                .message(error.getMessage())
                .build();
    }

    public static <T> ApiResponse<T> fail(ErrorCode error, String message) {
        return ApiResponse.<T>builder()
                .code(error.getCode())
                .message(message)
                .build();
    }
}