package com.yemeksepeti.controller;

import com.yemeksepeti.dto.request.OrderSaveRequestDto;
import com.yemeksepeti.repository.entity.Order;
import com.yemeksepeti.repository.entity.joinTables.JoinCustomerNameProductName;
import com.yemeksepeti.repository.view.VwOrderCustomer;
import com.yemeksepeti.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.yemeksepeti.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(ORDER)
public class OrderController {
    private final OrderService orderService;
    @PostMapping(SAVE) // 4. soru 1. yarısı (customer var mı diye kontrol et yada active mi diye)
    public ResponseEntity<Order> save(OrderSaveRequestDto dto){
        return ResponseEntity.ok(orderService.makeOrder(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }
    @PostMapping("/find-orders") // 7. soru
    public ResponseEntity<List<VwOrderCustomer>> findCustomerOrders(){
        return ResponseEntity.ok(orderService.findCustomerOrders());
    }
    @PostMapping("/customer-previous-orders") // 4. soru 2. yarısı
    public ResponseEntity<List<JoinCustomerNameProductName>> findPreviousOrders(Long id){
        return ResponseEntity.ok(orderService.findPreviousOrders(id));
    }
}
