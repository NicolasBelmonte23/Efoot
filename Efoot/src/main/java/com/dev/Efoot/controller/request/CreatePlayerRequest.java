package com.dev.Efoot.controller.request;

import com.dev.Efoot.entity.Position;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@Getter
@Setter
public class CreatePlayerRequest {
    @NotBlank
    private String name;
    @NotNull
    private Position position;
    @NotNull
    private int shirtNumber;
    private String urlImg;
    @NotNull
    private Long clubId;
}
