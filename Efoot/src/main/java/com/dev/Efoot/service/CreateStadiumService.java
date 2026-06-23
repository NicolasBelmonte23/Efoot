package com.dev.Efoot.service;

import com.dev.Efoot.controller.request.CreateStadiumRequest;
import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.entity.Stadium;
import com.dev.Efoot.mapper.StadiumMapper;
import com.dev.Efoot.repository.StadiumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateStadiumService {

    private final StadiumRepository stadiumRepository;
    private final StadiumMapper stadiumMapper;

    public StadiumResponse execute(CreateStadiumRequest stadiumRequest){
        Stadium save = stadiumRepository.save(stadiumMapper.toStadium(stadiumRequest));
        return stadiumMapper.toStadiumResponse(save);
    }
}
