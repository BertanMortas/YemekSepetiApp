package com.yemeksepeti.controller;

import com.yemeksepeti.dto.request.CustomerLoginRequestDto;
import com.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.yemeksepeti.dto.request.CustomerStatusRequestDto;
import com.yemeksepeti.dto.response.CustomerRegisterResponseDto;
import com.yemeksepeti.repository.entity.Customer;
import com.yemeksepeti.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import static com.yemeksepeti.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(CUSTOMER)
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping(REGISTER)
    public ResponseEntity<CustomerRegisterResponseDto> register(@RequestBody @Valid CustomerRegisterRequestDto dto){
        return ResponseEntity.ok(customerService.register(dto));
    }
    @PostMapping(STATUS)
    public ResponseEntity<Boolean> activateStatus(@RequestBody CustomerStatusRequestDto dto){
        return ResponseEntity.ok(customerService.activateStatus(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody CustomerLoginRequestDto dto){
        return ResponseEntity.ok(customerService.login(dto));
    }
    @GetMapping(FIND_ALL) //3. soru eksik active olanları getir bu herşeyi getiriyor
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }
}
