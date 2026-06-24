package com.dev.Efoot.service;

import com.dev.Efoot.controller.request.CreatePlayerRequest;
import com.dev.Efoot.controller.response.PlayerResponse;
import com.dev.Efoot.entity.Player;
import com.dev.Efoot.mapper.PlayerMapper;
import com.dev.Efoot.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreatePlayerService {
    private final PlayerRepository playerRepository;
    private final FindClubService findClubService;
    private final PlayerMapper mapper;

    public PlayerResponse execute(CreatePlayerRequest request){
        Player entity = mapper.toEntity(request);
        entity.setClub(findClubService.findById(request.getClubId()));
        Player player = playerRepository.save(entity);
        return mapper.toPlayerResponse(player);    }
}
