package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreateStadiumRequest;
import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.entity.Stadium;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StadiumMapper {

  StadiumResponse toStadiumResponse(Stadium stadium);

  Stadium toStadium(CreateStadiumRequest createStadiumRequest);
}
