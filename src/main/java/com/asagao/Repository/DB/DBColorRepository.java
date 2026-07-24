package com.asagao.Repository.DB;

import java.awt.Color;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.asagao.Mapper.ColorMapper;
import com.asagao.Repository.Interface.ColorRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class DBColorRepository implements ColorRepository{

	private final ColorMapper ColorMapper;

    @Override
    public List<Color> findAll() {
        return ColorMapper.findAll();
    }
}
