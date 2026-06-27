package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreateClubRequest;
import com.dev.Efoot.controller.response.ClubDetailResponse;
import com.dev.Efoot.controller.response.ClubResponse;
import com.dev.Efoot.entity.Club;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubResponse toClubResponse(Club club);

    ClubDetailResponse toClubDetailResponse(Club club);

    @Mapping(target = "stadium.id" , source = "stadiumId")
    Club toEntity(CreateClubRequest request);
}
