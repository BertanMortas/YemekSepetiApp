package com.yemeksepeti.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterResponseDto {
    String customerName;
    String password;
    String activationCode;
}
