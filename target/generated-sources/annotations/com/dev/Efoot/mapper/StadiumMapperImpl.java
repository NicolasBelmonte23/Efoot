package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreateStadiumRequest;
import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.entity.Stadium;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-26T11:41:03-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.16 (Microsoft)"
)
@Component
public class StadiumMapperImpl implements StadiumMapper {

    @Override
    public StadiumResponse toStadiumResponse(Stadium stadium) {
        if ( stadium == null ) {
            return null;
        }

        StadiumResponse.StadiumResponseBuilder stadiumResponse = StadiumResponse.builder();

        stadiumResponse.id( stadium.getId() );
        stadiumResponse.name( stadium.getName() );
        stadiumResponse.city( stadium.getCity() );
        stadiumResponse.capacity( stadium.getCapacity() );
        stadiumResponse.urlImg( stadium.getUrlImg() );

        return stadiumResponse.build();
    }

    @Override
    public Stadium toStadium(CreateStadiumRequest createStadiumRequest) {
        if ( createStadiumRequest == null ) {
            return null;
        }

        Stadium.StadiumBuilder stadium = Stadium.builder();

        stadium.name( createStadiumRequest.getName() );
        stadium.city( createStadiumRequest.getCity() );
        stadium.capacity( createStadiumRequest.getCapacity() );
        stadium.urlImg( createStadiumRequest.getUrlImg() );

        return stadium.build();
    }
}
