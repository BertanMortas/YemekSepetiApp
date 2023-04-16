package com.yemeksepeti.repository;

import com.yemeksepeti.repository.entity.Order;
import com.yemeksepeti.repository.entity.joinTables.JoinCustomerNameProductName;
import com.yemeksepeti.repository.view.VwOrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrderRepository extends JpaRepository<Order,Long> {
    @Query("select new com.yemeksepeti.repository.view.VwOrderCustomer(o.orderId, c.customerName, c.customerAddress) from Order as o " +
            "inner join Customer as c on c.customerId=o.customerId")
    List<VwOrderCustomer> findCustomersByOrder();
}
