package com.yemeksepeti.mapper;

import com.yemeksepeti.dto.request.RestaurantSaveRequestDto;
import com.yemeksepeti.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {
    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);
    Restaurant fromReqToRestaurant(final RestaurantSaveRequestDto dto);
}
