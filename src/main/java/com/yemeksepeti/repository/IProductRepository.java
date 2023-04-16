package com.yemeksepeti.repository;

import com.yemeksepeti.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    @Query(nativeQuery = true, value = "select * from yemeksepeti.tblproduct as p where p.product_id" +
            " in (select rp.product_ids from yemeksepeti.restaurant_product_ids as rp where rp.restaurant_restaurant_id=?1)")
    List<Product> findRestaurantProducts(Long id);

}
