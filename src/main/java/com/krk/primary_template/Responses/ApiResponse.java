package com.krk.primary_template.Responses;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private LocalDateTime timestamp;
    private String message;
    private int statusCode;
    private T data;
    private Object metadata;
    private String errorDetails;
    private String path;

    public ApiResponse(LocalDateTime timestamp, String message, int statusCode, T data, Object metadata,
            String errorDetails, String path) {
        this.timestamp = timestamp;
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
        this.metadata = metadata;
        this.errorDetails = errorDetails;
        this.path = path;
    }

    public static <T> ApiResponse<T> success(String message, int statusCode, T data, Object metadata, String path) {
        return new ApiResponse<>(LocalDateTime.now(), message, statusCode, data, metadata, null, path);
    }

    public static <T> ApiResponse<T> error(String message, int statusCode, String errorDetails, String path) {
        return new ApiResponse<>(LocalDateTime.now(), message, statusCode, null, null, errorDetails, path);
    }

    // Getters and Setters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public T getData() {
        return data;
    }

    public Object getMetadata() {
        return metadata;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public String getPath() {
        return path;
    }
}