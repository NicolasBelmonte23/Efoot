package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreateStadiumRequest;
import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.entity.Stadium;
import junit.framework.TestCase;
import org.mapstruct.factory.Mappers;

public class StadiumMapperTest extends TestCase {

    private final StadiumMapper mapper = Mappers.getMapper(StadiumMapper.class);

    public void testToStadiumResponse() {
        Stadium stadium = Stadium.builder()
                .id(1L)
                .name("Stadium A")
                .city("Porto Alegre")
                .capacity(50000)
                .urlImg("https://example.com/stadium-a.jpg")
                .build();
        StadiumResponse stadiumResponse = mapper.toStadiumResponse(stadium);
        assertNotNull(stadiumResponse);
        assertEquals(stadium.getId(), stadiumResponse.getId());
        assertEquals(stadium.getName(), stadiumResponse.getName());
        assertEquals(stadium.getCity(), stadiumResponse.getCity());
        assertEquals(stadium.getCapacity(), stadiumResponse.getCapacity());
        assertEquals(stadium.getUrlImg(), stadiumResponse.getUrlImg());
    }

    public void testToStadium() {
        CreateStadiumRequest request = CreateStadiumRequest.builder()
                .name("Stadium A")
                .city("Porto Alegre")
                .capacity(50000)
                .urlImg("https://example.com/stadium-a.jpg")
                .build();
        Stadium stadium = mapper.toStadium(request);
        assertNotNull(stadium);
        assertEquals(request.getName(), stadium.getName());
        assertEquals(request.getCity(), stadium.getCity());
        assertEquals(request.getCapacity(), stadium.getCapacity());
        assertEquals(request.getUrlImg(), stadium.getUrlImg());
    }
}