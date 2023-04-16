package com.yemeksepeti.repository.entity.joinTables;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tblJoinOrderProductRestaurant")
public class JoinOrderProductRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    //@Column(name = "customer_name")
    private String restaurantName;
    //@Column(name = "product_name")
    private String productName;
}
