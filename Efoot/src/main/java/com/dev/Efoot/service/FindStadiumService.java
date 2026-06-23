package com.dev.Efoot.service;

import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.entity.Stadium;
import com.dev.Efoot.exception.ResourceNotFoundException;
import com.dev.Efoot.mapper.StadiumMapper;
import com.dev.Efoot.repository.StadiumRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class FindStadiumService {
    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public Page<StadiumResponse> listAllStadium(Pageable pageable){
        return stadiumRepository.findAll(pageable)
                .map(stadiumMapper::toStadiumResponse);
    }

    public Stadium findById(Long id){
        return stadiumRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stadium not found for id: " + id));
    }
}
