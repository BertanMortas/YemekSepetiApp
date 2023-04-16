package com.yemeksepeti.mapper;

import com.yemeksepeti.dto.request.OrderSaveRequestDto;
import com.yemeksepeti.repository.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IOrderMapper {
    IOrderMapper INSTANCE = Mappers.getMapper(IOrderMapper.class);
    Order fromSaveDtoToOrder(final OrderSaveRequestDto dto);
}
