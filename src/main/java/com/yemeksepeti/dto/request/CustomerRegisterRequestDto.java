package com.yemeksepeti.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRegisterRequestDto {
    String customerName;
    String password;
    String rePassword;
    String customerAddress;
    String email;
    String cardDetails;
}
