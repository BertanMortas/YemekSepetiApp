package com.yemeksepeti.repository.view;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VwOrderCustomer {
    private Long orderId;
    private String customerName;
    private String customerAddress;
}
