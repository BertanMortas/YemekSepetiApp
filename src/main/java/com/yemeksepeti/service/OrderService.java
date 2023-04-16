package com.yemeksepeti.service;

import com.yemeksepeti.dto.request.OrderSaveRequestDto;
import com.yemeksepeti.exception.ErrorType;
import com.yemeksepeti.exception.YemeksepetiManagerException;
import com.yemeksepeti.mapper.IOrderMapper;
import com.yemeksepeti.repository.IJoinCustomerNameProductNameRepository;
import com.yemeksepeti.repository.IOrderRepository;
import com.yemeksepeti.repository.entity.Customer;
import com.yemeksepeti.repository.entity.Order;
import com.yemeksepeti.repository.entity.joinTables.JoinCustomerNameProductName;
import com.yemeksepeti.repository.view.VwOrderCustomer;
import com.yemeksepeti.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService implements ICrudService<Order,Long> {
    private final IOrderRepository orderRepository;
    private final CustomerService customerService;
    private final IJoinCustomerNameProductNameRepository joinRepository;

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Iterable<Order> saveAll(Iterable<Order> t) {
        return null;
    }

    @Override
    public Order update(Order order) {
        return null;
    }

    @Override
    public Order delete(Long aLong) {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return Optional.empty();
    }
    public Order makeOrder(OrderSaveRequestDto dto){
       Optional<Customer> customer= customerService.findById(dto.getCustomerId());
        if (customer.isEmpty()) {
            throw new YemeksepetiManagerException(ErrorType.USER_NOT_FOUND);
        }
        Order order = IOrderMapper.INSTANCE.fromSaveDtoToOrder(dto);
        return save(order);
    }
    public List<VwOrderCustomer> findCustomerOrders(){
       return orderRepository.findCustomersByOrder();
    }
    public List<JoinCustomerNameProductName> findPreviousOrders(Long id){
        Optional<Customer> customer= customerService.findById(id);
        if (customer.isEmpty()) {
            throw new YemeksepetiManagerException(ErrorType.USER_NOT_FOUND);
        }
        return joinRepository.findPreviousOrders(id);
    }
}
