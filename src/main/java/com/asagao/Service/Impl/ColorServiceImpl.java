package com.asagao.Service.Impl;

import java.awt.Color;
import java.util.List;

import org.springframework.stereotype.Service;

import com.asagao.Repository.Interface.ColorRepository;
import com.asagao.Service.Interface.ColorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService{

	private final ColorRepository ColorRepository;

    @Override
    public List<Color> getColors() {
        return ColorRepository.findAll();
    }
}
