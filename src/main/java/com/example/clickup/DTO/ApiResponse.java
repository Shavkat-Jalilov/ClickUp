package com.example.clickup.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponse {
    private String message;
    private boolean holat;
    private Object object;

    public ApiResponse(String message, boolean holat) {
        this.message = message;
        this.holat = holat;
    }

    public boolean isSuccess() {
        return true;
    }
}
