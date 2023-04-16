package com.yemeksepeti.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderSaveRequestDto {
    private Long customerId;
    private List<Long> productIds;
}
