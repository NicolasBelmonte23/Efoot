package com.dev.Efoot.controller;

import com.dev.Efoot.controller.request.CreateStadiumRequest;
import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.service.CreateStadiumService;
import com.dev.Efoot.service.FindStadiumService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/stadiums")
public class StadiumController {

    private final FindStadiumService findStadiumService;
    private final CreateStadiumService createStadiumService;

    public StadiumController(FindStadiumService findStadiumService, CreateStadiumService createStadiumService) {
        this.findStadiumService = findStadiumService;
        this.createStadiumService = createStadiumService;
    }


    @PreAuthorize("hasAnyAuthority('SCOPE_club:read', 'SCOPE_admin:all')")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<StadiumResponse> listAllStadiums(Pageable pageable){
        return findStadiumService.listAllStadium(pageable);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_club:write', 'SCOPE_admin:all')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StadiumResponse create(@Valid @RequestBody CreateStadiumRequest request){
        return createStadiumService.execute(request);
    }

}
