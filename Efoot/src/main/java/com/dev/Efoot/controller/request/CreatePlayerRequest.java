package com.dev.Efoot.controller.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePlayerRequest {
    @NotBlank
    private String name;
    @NotNull
    private String position;
    @NotNull
    private int shirtNumber;
    private String urlImg;
    @NotNull
    private Long clubId;
}
