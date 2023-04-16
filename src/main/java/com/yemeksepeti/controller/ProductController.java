package com.yemeksepeti.controller;

import com.yemeksepeti.dto.request.ProductSaveRequestDto;
import com.yemeksepeti.repository.entity.Product;
import com.yemeksepeti.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.yemeksepeti.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService productService;
    @PostMapping(SAVE)
    public ResponseEntity<Product> save(@RequestBody @Valid ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.saveDto(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @PostMapping("/find-restaurant-products") // 6. soru
    public ResponseEntity<List<Product>> findRestaurantProducts(@RequestBody Long id){
        return ResponseEntity.ok(productService.findRestaurantProducts(id));
    }
}
