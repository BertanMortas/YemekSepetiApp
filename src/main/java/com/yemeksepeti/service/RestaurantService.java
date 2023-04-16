package com.yemeksepeti.service;

import com.yemeksepeti.dto.request.RestaurantSaveRequestDto;
import com.yemeksepeti.exception.ErrorType;
import com.yemeksepeti.exception.YemeksepetiManagerException;
import com.yemeksepeti.mapper.IRestaurantMapper;
import com.yemeksepeti.repository.IJoinOrderProductRestaurantRepository;
import com.yemeksepeti.repository.IRestaurantRepository;
import com.yemeksepeti.repository.entity.Product;
import com.yemeksepeti.repository.entity.Restaurant;
import com.yemeksepeti.repository.entity.joinTables.JoinOrderProductRestaurant;
import com.yemeksepeti.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService implements ICrudService<Restaurant,Long> {
    private final IRestaurantRepository restaurantRepository;
    private final IJoinOrderProductRestaurantRepository joinRepository;
   // private final ProductService productService;
    //loop a girdi

    @Override
    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Iterable<Restaurant> saveAll(Iterable<Restaurant> t) {
        return null;
    }

    @Override
    public Restaurant update(Restaurant restaurant) {
        return null;
    }

    @Override
    public Restaurant delete(Long aLong) {
        return null;
    }

    @Override
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> findById(Long aLong) {
        return restaurantRepository.findById(aLong);
    }
    public Restaurant saveDto(RestaurantSaveRequestDto dto){
        Restaurant restaurant = IRestaurantMapper.INSTANCE.fromReqToRestaurant(dto);
/*        List<Product> productList = productService.findRestaurantProducts(restaurant.getRestaurantId());
        dto.getProductIds().forEach(product ->{
           productList.forEach(product1 -> {
               if (product1.equals(product)) {
                   throw new YemeksepetiManagerException(ErrorType.PRODUCT_DUPLICATE);
               }
           });
        });*/
        //loop a girdi
        return save(restaurant);
    }
    public List<JoinOrderProductRestaurant> findPreviousOrdersByRestaurantName(Long id){
        Optional<Restaurant> restaurant= findById(id);
        if (restaurant.isEmpty()) {
            throw new YemeksepetiManagerException(ErrorType.RESTAURANT_NOT_FOUND);
        }
        return joinRepository.findPreviousOrdersByRestaurant(id);
    }
}
