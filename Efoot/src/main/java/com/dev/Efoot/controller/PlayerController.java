package com.dev.Efoot.controller;

import com.dev.Efoot.controller.request.CreatePlayerRequest;
import com.dev.Efoot.controller.response.PlayerDetailResponse;
import com.dev.Efoot.controller.response.PlayerResponse;
import com.dev.Efoot.entity.Player;
import com.dev.Efoot.mapper.PlayerMapper;
import com.dev.Efoot.service.CreatePlayerService;
import com.dev.Efoot.service.FindPlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class PlayerController {
    private final FindPlayerService findPlayerService;
    private final CreatePlayerService createPlayerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PlayerResponse> findPlayer(Pageable pageable){
        return findPlayerService.findAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PlayerDetailResponse findPlayerById(@PathVariable Long id){
        return findPlayerService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerResponse create(@Valid @RequestBody CreatePlayerRequest request){
       return createPlayerService.execute(request);
    }

}
