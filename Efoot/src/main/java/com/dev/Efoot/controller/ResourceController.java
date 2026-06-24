package com.dev.Efoot.controller;

import com.dev.Efoot.controller.response.PositionResponse;
import com.dev.Efoot.entity.Position;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @GetMapping("/positions")
    @ResponseStatus(HttpStatus.OK)
    public List<PositionResponse> getPosition(){
        return Arrays.stream(Position.values())
                .map(position -> new PositionResponse(position.name(),position.getLabel()))
                .toList();
    }
}
