package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreatePlayerRequest;
import com.dev.Efoot.controller.response.ClubResponse;
import com.dev.Efoot.controller.response.PlayerDetailResponse;
import com.dev.Efoot.controller.response.PlayerResponse;
import com.dev.Efoot.entity.Club;
import com.dev.Efoot.entity.Player;
import com.dev.Efoot.entity.Position;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-26T11:41:03-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.16 (Microsoft)"
)
@Component
public class PlayerMapperImpl implements PlayerMapper {

    @Override
    public PlayerResponse toPlayerResponse(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerResponse playerResponse = new PlayerResponse();

        playerResponse.setPosition( mapPositionToString( player.getPosition() ) );
        playerResponse.setId( player.getId() );
        playerResponse.setName( player.getName() );
        playerResponse.setShirtNumber( player.getShirtNumber() );
        playerResponse.setUrlImg( player.getUrlImg() );

        return playerResponse;
    }

    @Override
    public PlayerDetailResponse toPlayerDetailResponse(Player player) {
        if ( player == null ) {
            return null;
        }

        PlayerDetailResponse playerDetailResponse = new PlayerDetailResponse();

        playerDetailResponse.setPosition( mapPositionToString( player.getPosition() ) );
        playerDetailResponse.setId( player.getId() );
        playerDetailResponse.setName( player.getName() );
        playerDetailResponse.setShirtNumber( player.getShirtNumber() );
        playerDetailResponse.setUrlImg( player.getUrlImg() );
        playerDetailResponse.setClub( clubToClubResponse( player.getClub() ) );

        return playerDetailResponse;
    }

    @Override
    public Player toEntity(CreatePlayerRequest request) {
        if ( request == null ) {
            return null;
        }

        Player.PlayerBuilder player = Player.builder();

        player.club( createPlayerRequestToClub( request ) );
        player.name( request.getName() );
        if ( request.getPosition() != null ) {
            player.position( Enum.valueOf( Position.class, request.getPosition() ) );
        }
        player.shirtNumber( request.getShirtNumber() );
        player.urlImg( request.getUrlImg() );

        return player.build();
    }

    protected ClubResponse clubToClubResponse(Club club) {
        if ( club == null ) {
            return null;
        }

        ClubResponse clubResponse = new ClubResponse();

        clubResponse.setId( club.getId() );
        clubResponse.setName( club.getName() );
        clubResponse.setFounded( club.getFounded() );
        clubResponse.setUrlImg( club.getUrlImg() );

        return clubResponse;
    }

    protected Club createPlayerRequestToClub(CreatePlayerRequest createPlayerRequest) {
        if ( createPlayerRequest == null ) {
            return null;
        }

        Club.ClubBuilder club = Club.builder();

        club.id( createPlayerRequest.getClubId() );

        return club.build();
    }
}
