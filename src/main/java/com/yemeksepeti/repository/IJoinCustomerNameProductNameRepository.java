package com.yemeksepeti.repository;

import com.yemeksepeti.repository.entity.joinTables.JoinCustomerNameProductName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJoinCustomerNameProductNameRepository extends JpaRepository<JoinCustomerNameProductName,Long> {
    @Query(nativeQuery = true, value = "SELECT p.product_id, c.customer_name, p.product_name FROM yemeksepeti.tblorder as o\n" +
            "inner join yemeksepeti.tblcustomer as c on o.customer_id = c.customer_id\n" +
            "inner join yemeksepeti.order_product_ids as op on op.order_order_id = o.order_id\n" +
            "inner join yemeksepeti.tblproduct as p on p.product_id=op.product_ids\n" +
            "where o.customer_id=?1")
    List<JoinCustomerNameProductName> findPreviousOrders(Long id);

    /**
     * SELECT * FROM yemeksepeti.tblorder as o
     * inner join yemeksepeti.tblcustomer as c on o.customer_id = c.customer_id
     * inner join yemeksepeti.order_product_ids as op on op.order_order_id = o.order_id
     * inner join yemeksepeti.tblproduct as p on p.product_id=op.product_ids
     * inner join yemeksepeti.restaurant_product_ids as rp on rp.product_ids = p.product_id
     * inner join yemeksepeti.tblrestaurant as r on r.restaurant_id = rp.restaurant_restaurant_id
     * where o.customer_id=4;
     */
}
