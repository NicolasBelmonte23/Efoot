package com.dev.Efoot.service;

import com.dev.Efoot.controller.request.CreateStadiumRequest;
import com.dev.Efoot.entity.Stadium;
import com.dev.Efoot.mapper.StadiumMapper;
import com.dev.Efoot.repository.StadiumRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CreateStadiumServiceTest {

    @InjectMocks
    CreateStadiumService createStadiumService;

    @Mock
    StadiumRepository stadiumRepository;
    @Mock
    StadiumMapper stadiumMapper;
    @Captor
    ArgumentCaptor<Stadium> stadiumCaptor;

    @Test
    @DisplayName("Should create a stadium successfully")
    void shouldCreateStadium() {
        CreateStadiumRequest request = CreateStadiumRequest.builder()
                .name("Test Stadium")
                .city("Test City")
                .capacity(50000)
                .urlImg("http://example.com/stadium.jpg")
                .build();

        Stadium stadium = Stadium.builder()
                .name(request.getName())
                .city(request.getCity())
                .capacity(request.getCapacity())
                .urlImg(request.getUrlImg())
                .build();

        Mockito.when(stadiumMapper.toStadium(request)).thenReturn(stadium);

        createStadiumService.execute(request);

        Mockito.verify(stadiumMapper).toStadium(request);
        Mockito.verify(stadiumRepository).save(Mockito.any());
        Mockito.verify(stadiumMapper).toStadiumResponse(Mockito.any());

        Mockito.verify(stadiumRepository).save(stadiumCaptor.capture());
        Stadium savedStadium = stadiumCaptor.getValue();
        assertNotNull(savedStadium);
    }
}