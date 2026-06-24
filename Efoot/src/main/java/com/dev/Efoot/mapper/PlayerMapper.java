package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreatePlayerRequest;
import com.dev.Efoot.controller.response.PlayerDetailResponse;
import com.dev.Efoot.controller.response.PlayerResponse;
import com.dev.Efoot.entity.Player;
import com.dev.Efoot.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @Mapping(target = "position" , source = "position", qualifiedByName = "enumToString")
    PlayerResponse toPlayerResponse(Player player);

    @Mapping(target = "position" , source = "position", qualifiedByName = "enumToString")
    PlayerDetailResponse toPlayerDetailResponse(Player player);

    @Mapping(target = "club.id" , source = "clubId")
    Player toEntity(CreatePlayerRequest request);

    @Named("enumToString")
    default String mapPositionToString(Position position){
        return position != null ? position.getLabel() : null;
    }


}
