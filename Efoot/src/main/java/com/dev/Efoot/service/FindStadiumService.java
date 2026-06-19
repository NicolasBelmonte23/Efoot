package com.dev.Efoot.service;

import com.dev.Efoot.controller.response.StadiumResponse;
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

    public Page<StadiumResponse> listAllStadium(Pageable pageable){
        return stadiumRepository.findAll(pageable)
                .map(stadium -> StadiumMapper.toStadiumResponse(stadium));
    }
}
