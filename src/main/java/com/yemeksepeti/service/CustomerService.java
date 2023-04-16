package com.yemeksepeti.service;

import com.yemeksepeti.dto.request.CustomerLoginRequestDto;
import com.yemeksepeti.dto.request.CustomerRegisterRequestDto;
import com.yemeksepeti.dto.request.CustomerStatusRequestDto;
import com.yemeksepeti.dto.response.CustomerRegisterResponseDto;
import com.yemeksepeti.exception.ErrorType;
import com.yemeksepeti.exception.YemeksepetiManagerException;
import com.yemeksepeti.mapper.ICustomerMapper;
import com.yemeksepeti.repository.ICustomerRepository;
import com.yemeksepeti.repository.entity.Customer;
import com.yemeksepeti.utility.CodeGenerator;
import com.yemeksepeti.utility.ICrudService;
import com.yemeksepeti.utility.enums.EStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICrudService<Customer,Long> {
    private final ICustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Iterable<Customer> saveAll(Iterable<Customer> t) {
        return customerRepository.saveAll(t);
    }

    @Override
    public Customer update(Customer customer) {
        return save(customer);
    }

    @Override
    public Customer delete(Long aLong) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findById(Long aLong) {
        return customerRepository.findById(aLong);
    }
    public CustomerRegisterResponseDto register(CustomerRegisterRequestDto dto){
        Customer customer = ICustomerMapper.INSTANCE.fromReqToCustomer(dto);
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(dto.getEmail());
        if (optionalCustomer.isPresent()) {
            throw new YemeksepetiManagerException(ErrorType.EMAIL_DUPLICATE);
        }
        if (!dto.getPassword().equals(dto.getRePassword())) {
            throw new YemeksepetiManagerException(ErrorType.PASSWORD_ERROR);
        }
        customer.setActivationCode(CodeGenerator.generateCode());
        save(customer);
        return ICustomerMapper.INSTANCE.fromCustomerToDto(customer);
    }
    public Boolean activateStatus(CustomerStatusRequestDto dto){
        Optional<Customer> customer = findById(dto.getCustomerId());
        if (customer.isEmpty()) {
            throw new YemeksepetiManagerException(ErrorType.USER_NOT_FOUND);
        }
        if (!customer.get().getActivationCode().equals(dto.getActivationCode())) {
            throw new YemeksepetiManagerException(ErrorType.ACTIVATE_CODE_ERROR);
        }
        customer.get().setStatus(EStatus.ACTIVE);
        update(customer.get());
        return true;
    }
    public Boolean login(CustomerLoginRequestDto dto){
        Optional<Customer> customer = customerRepository.findByPasswordAndCustomerName(dto.getPassword(), dto.getCustomerName());
        if (customer.isEmpty()) {
            throw new YemeksepetiManagerException(ErrorType.USER_NOT_FOUND);
        }else if (!customer.get().getStatus().equals(EStatus.ACTIVE)){
            throw new YemeksepetiManagerException(ErrorType.USER_NOT_ACTIVE);
        }
        return true;
    }
}
