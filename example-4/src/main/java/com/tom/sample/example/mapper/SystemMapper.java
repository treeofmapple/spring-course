package com.tom.sample.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import com.tom.sample.example.dto.ProductRequest;
import com.tom.sample.example.dto.ProductResponse;
import com.tom.sample.example.model.Product;

@Service
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SystemMapper {

	SystemMapper INSTANCE = Mappers.getMapper(SystemMapper.class);
	
	@Mapping(source = "name", target = "name")
	@Mapping(source = "price", target = "price")
	@Mapping(source = "manufacturer", target = "manufacturer")
	@Mapping(source = "quantity", target = "quantity")
	Product buildAttributes(ProductRequest request); 
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "name", target = "name")
	@Mapping(source = "quantity", target = "quantity")
	@Mapping(source = "price", target = "price")
	@Mapping(source = "manufacturer", target = "manufacturer")
	@Mapping(source = "active", target = "active")
	@Mapping(source = "lastUpdated", target = "lastUpdated")
	@Mapping(source = "dateCreated", target = "dateCreated")
	ProductResponse buildResponse(Product product);
	
}
