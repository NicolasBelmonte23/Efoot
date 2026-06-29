package com.dev.Efoot.mapper;

import junit.framework.TestCase;
import com.dev.Efoot.entity.Club;
import com.dev.Efoot.entity.Stadium;
import com.dev.Efoot.controller.response.ClubResponse;
import com.dev.Efoot.controller.request.CreateClubRequest;
import org.mapstruct.factory.Mappers;
import java.time.LocalDate;

public class ClubMapperTest extends TestCase {
    private ClubMapper mapper;

    @Override
    protected void setUp() {
        mapper = Mappers.getMapper(ClubMapper.class);
    }

    public void testToClubResponse() {
        Club club = Club.builder()
                .id(1L)
                .name("Test Club")
                .founded(LocalDate.of(2000, 5, 15))
                .urlImg("https://example.com/club.jpg")
                .build();

        ClubResponse clubResponse = mapper.toClubResponse(club);
        assertNotNull(clubResponse);
        assertEquals(club.getId(), clubResponse.getId());
        assertEquals(club.getName(), clubResponse.getName());
        assertEquals(club.getFounded(), clubResponse.getFounded());
        assertEquals(club.getUrlImg(), clubResponse.getUrlImg());
    }

    public void testToClubDetailResponse() {
        Stadium stadium = Stadium.builder()
                .id(1L)
                .name("Stadium Test")
                .city("Test City")
                .capacity(50000)
                .urlImg("https://example.com/stadium.jpg")
                .build();

        Club club = Club.builder()
                .id(1L)
                .name("Test Club")
                .founded(LocalDate.of(2000, 5, 15))
                .urlImg("https://example.com/club.jpg")
                .stadium(stadium)
                .build();

        var clubDetailResponse = mapper.toClubDetailResponse(club);
        assertNotNull(clubDetailResponse);
        assertEquals(club.getId(), clubDetailResponse.getId());
        assertEquals(club.getName(), clubDetailResponse.getName());
        assertEquals(club.getFounded(), clubDetailResponse.getFounded());
        assertEquals(club.getUrlImg(), clubDetailResponse.getUrlImg());
    }

    public void testToEntity() {
        CreateClubRequest request = new CreateClubRequest(
                "New Club",
                LocalDate.of(2010, 3, 20),
                "https://example.com/newclub.jpg",
                2L
        );

        Club club = mapper.toEntity(request);
        assertNotNull(club);
        assertEquals(request.getName(), club.getName());
        assertEquals(request.getFounded(), club.getFounded());
        assertEquals(request.getUrlImg(), club.getUrlImg());
        assertNotNull(club.getStadium());
        assertEquals(request.getStadiumId(), club.getStadium().getId());
    }
}