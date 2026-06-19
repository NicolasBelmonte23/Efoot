package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreateStadiumRequest;
import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.entity.Stadium;

public class StadiumMapper {

    public static StadiumResponse toStadiumResponse(Stadium stadium){
        return StadiumResponse.builder()
                .id(stadium.getId())
                .name(stadium.getName())
                .city(stadium.getCity())
                .capacity(stadium.getCapacity())
                .urlImg(stadium.getUrlImg())

                .build();
    }

    public static Stadium toStadium(CreateStadiumRequest createStadiumRequest){
        return Stadium.builder()
                .name(createStadiumRequest.getName())
                .city(createStadiumRequest.getCity())
                .capacity(createStadiumRequest.getCapacity())
                .urlImg(createStadiumRequest.getUrlImg())
                .build();
    }
}
