package com.yemeksepeti.service;

import com.yemeksepeti.dto.request.ProductSaveRequestDto;
import com.yemeksepeti.exception.ErrorType;
import com.yemeksepeti.exception.YemeksepetiManagerException;
import com.yemeksepeti.mapper.IProductMapper;
import com.yemeksepeti.repository.IProductRepository;
import com.yemeksepeti.repository.entity.Product;
import com.yemeksepeti.repository.entity.Restaurant;
import com.yemeksepeti.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements ICrudService<Product,Long> {
    private final IProductRepository productRepository;
    private final RestaurantService restaurantService;

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Iterable<Product> saveAll(Iterable<Product> t) {
        return null;
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public Product delete(Long aLong) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return Optional.empty();
    }
    public Product saveDto(ProductSaveRequestDto dto){
        Product product = IProductMapper.INSTANCE.fromSaveDtoToProduct(dto);
        return save(product);
    }
    public List<Product> findRestaurantProducts(Long id){
       Optional<Restaurant> restaurant= restaurantService.findById(id);
        if (restaurant.isEmpty()) {
            throw new YemeksepetiManagerException(ErrorType.RESTAURANT_NOT_FOUND);
        }
        return productRepository.findRestaurantProducts(id);
    }
}
