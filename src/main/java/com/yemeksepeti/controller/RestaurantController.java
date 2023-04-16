package com.yemeksepeti.controller;

import com.yemeksepeti.dto.request.RestaurantSaveRequestDto;
import com.yemeksepeti.repository.entity.Restaurant;
import com.yemeksepeti.repository.entity.joinTables.JoinOrderProductRestaurant;
import com.yemeksepeti.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.yemeksepeti.constant.EndPointList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(RESTAURANT)
public class RestaurantController {
    private final RestaurantService restaurantService;
    @PostMapping(SAVE)
    public ResponseEntity<Restaurant> save(@RequestBody @Valid RestaurantSaveRequestDto dto){
        return ResponseEntity.ok(restaurantService.saveDto(dto));
    }
    @GetMapping(FIND_ALL)
    public ResponseEntity<List<Restaurant>> findAll(){
        return ResponseEntity.ok(restaurantService.findAll());
    }
    @PostMapping("/find-previous-restaurant-orders")// 5. soru
    public ResponseEntity<List<JoinOrderProductRestaurant>> findPreviousOrdersByRestaurantName(@RequestBody Long id){
       return ResponseEntity.ok(restaurantService.findPreviousOrdersByRestaurantName(id));
    }
}
