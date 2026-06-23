package com.dev.Efoot.service;

import com.dev.Efoot.controller.response.ClubResponse;
import com.dev.Efoot.entity.Club;
import com.dev.Efoot.exception.ResourceNotFoundException;
import com.dev.Efoot.mapper.ClubMapper;
import com.dev.Efoot.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper mapper;

    public Page<ClubResponse> findAll(Pageable pageable){
       return clubRepository.findAll(pageable)
                .map(mapper::toClubResponse);
    }

    public Club findById(Long id){
        return clubRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Club not found for id: " + id));    }

}
