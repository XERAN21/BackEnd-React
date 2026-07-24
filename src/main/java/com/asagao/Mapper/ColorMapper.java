package com.asagao.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.asagao.Domain.Color; 

@Mapper
public interface ColorMapper {

	List<Color> findAll();
}
