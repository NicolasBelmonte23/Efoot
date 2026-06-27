package com.dev.Efoot.controller;

import com.dev.Efoot.controller.request.CreateClubRequest;
import com.dev.Efoot.controller.response.ClubDetailResponse;
import com.dev.Efoot.controller.response.ClubResponse;
import com.dev.Efoot.controller.response.PlayerResponse;
import com.dev.Efoot.entity.Club;
import com.dev.Efoot.mapper.ClubMapper;
import com.dev.Efoot.service.CreateClubService;
import com.dev.Efoot.service.FindClubService;
import com.dev.Efoot.service.FindPlayerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
@RequiredArgsConstructor
public class ClubController {

    private final FindClubService findClubService;
    private final ClubMapper mapper;
    private final CreateClubService createClubService;
    private final FindPlayerService findPlayerService;

    @PreAuthorize("hasAnyAuthority('SCOPE_club:read', 'SCOPE_admin:all')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ClubResponse> findAll(Pageable pageable){
        return findClubService.findAll(pageable);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_club:read', 'SCOPE_admin:all')")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClubDetailResponse findById(@PathVariable Long id){
        Club byId = findClubService.findById(id);
        return mapper.toClub(byId);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_club:write', 'SCOPE_admin:all')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClubDetailResponse create(@Valid @RequestBody CreateClubRequest request){
        return createClubService.execute(request);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_club:read', 'SCOPE_admin:all')")
    @GetMapping("/{id}/players")
    public List<PlayerResponse> findPlayerByClubId(@PathVariable Long id){
        return findPlayerService.findByClubId(id);    }

}
