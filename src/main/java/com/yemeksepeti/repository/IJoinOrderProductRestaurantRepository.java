package com.yemeksepeti.repository;

import com.yemeksepeti.repository.entity.joinTables.JoinOrderProductRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJoinOrderProductRestaurantRepository extends JpaRepository<JoinOrderProductRestaurant, Long> {
    @Query(nativeQuery = true,value = "SELECT p.product_id, r.restaurant_name, p.product_name FROM yemeksepeti.tblorder as o\n" +
            "inner join yemeksepeti.tblcustomer as c on o.customer_id = c.customer_id\n" +
            "inner join yemeksepeti.order_product_ids as op on op.order_order_id = o.order_id\n" +
            "inner join yemeksepeti.tblproduct as p on p.product_id=op.product_ids\n" +
            "inner join yemeksepeti.restaurant_product_ids as rp on rp.product_ids = p.product_id\n" +
            "inner join yemeksepeti.tblrestaurant as r on r.restaurant_id = rp.restaurant_restaurant_id\n" +
            "where r.restaurant_id =?1")
    List<JoinOrderProductRestaurant> findPreviousOrdersByRestaurant(Long id);
}
