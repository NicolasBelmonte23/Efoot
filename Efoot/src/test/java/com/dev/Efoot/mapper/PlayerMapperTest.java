package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.response.PlayerResponse;
import com.dev.Efoot.entity.Club;
import com.dev.Efoot.entity.Player;
import junit.framework.TestCase;
import org.mapstruct.factory.Mappers;

public class PlayerMapperTest extends TestCase{
    private PlayerMapper mapper;

    @Override
    protected void setUp() {
        mapper = Mappers.getMapper(PlayerMapper.class);
    }

    public void testToPlayerResponse(       ) {
        Player build = Player.builder()
                .id(1L)
                .name("Player A")
                .position(com.dev.Efoot.entity.Position.FORWARD)
                .shirtNumber(10)
                .urlImg("https://example.com/player-a.jpg")
                .build();
        PlayerResponse playerResponse = mapper.toPlayerResponse(build);
        assertNotNull(playerResponse);
        assertEquals(build.getId(), playerResponse.getId());
        assertEquals(build.getName(), playerResponse.getName());
        assertEquals(build.getPosition().getLabel(), playerResponse.getPosition());
        assertEquals(build.getShirtNumber(), playerResponse.getShirtNumber());
        assertEquals(build.getUrlImg(), playerResponse.getUrlImg());
    }

    public void testToPlayerDetailResponse() {
        Club club = com.dev.Efoot.entity.Club.builder()
                .id(1L)
                .name("Test Club")
                .urlImg("https://example.com/club.jpg")
                .build();

        Player build = Player.builder()
                .id(1L)
                .name("Player A")
                .position(com.dev.Efoot.entity.Position.FORWARD)
                .shirtNumber(10)
                .urlImg("https://example.com/player-a.jpg")
                .club(club)
                .build();

        var playerDetailResponse = mapper.toPlayerDetailResponse(build);
        assertNotNull(playerDetailResponse);
        assertEquals(build.getId(), playerDetailResponse.getId());
        assertEquals(build.getName(), playerDetailResponse.getName());
        assertEquals(build.getPosition().getLabel(), playerDetailResponse.getPosition());
        assertEquals(build.getShirtNumber(), playerDetailResponse.getShirtNumber());
        assertEquals(build.getUrlImg(), playerDetailResponse.getUrlImg());
    }

    public void testToEntity() {
        com.dev.Efoot.controller.request.CreatePlayerRequest request = 
                new com.dev.Efoot.controller.request.CreatePlayerRequest(
                        "Player B",
                        "MIDFIELDER",
                        5,
                        "https://example.com/player-b.jpg",
                        2L
                );

        Player player = mapper.toEntity(request);
        assertNotNull(player);
        assertEquals(request.getName(), player.getName());
        assertEquals(request.getShirtNumber(), player.getShirtNumber());
        assertEquals(request.getUrlImg(), player.getUrlImg());
        assertNotNull(player.getClub());
        assertEquals(request.getClubId(), player.getClub().getId());
    }
}