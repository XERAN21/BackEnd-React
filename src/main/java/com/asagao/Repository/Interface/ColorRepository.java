package com.asagao.Repository.Interface;

import java.util.List;

import com.asagao.Domain.Color; 

public interface ColorRepository {

	List<Color> findAll();
}
