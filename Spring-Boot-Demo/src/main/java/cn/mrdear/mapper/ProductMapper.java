package cn.mrdear.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.mrdear.entity.Product;

@Mapper
public interface ProductMapper {
	
	List<Product> findAllProds();

}
