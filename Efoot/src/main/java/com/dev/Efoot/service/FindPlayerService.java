package com.dev.Efoot.service;

import com.dev.Efoot.controller.response.PlayerDetailResponse;
import com.dev.Efoot.controller.response.PlayerResponse;
import com.dev.Efoot.exception.ResourceNotFoundException;
import com.dev.Efoot.mapper.PlayerMapper;
import com.dev.Efoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    public Page<PlayerResponse> findAll(Pageable pageable){
        return playerRepository.findAll(pageable)
                .map(mapper::toPlayerResponse);
    }

    public PlayerDetailResponse findById(Long id){
        return playerRepository.findById(id)
                .map(mapper::toPlayerDetailResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Player not found id:" + id));
    }

    public List<PlayerResponse> findByClubId(Long id){
        return playerRepository.findClubById(id)
                .stream()
                .map(mapper::toPlayerResponse)
                .toList();
    }
}
