package com.dev.Efoot.mapper;

import com.dev.Efoot.controller.request.CreateClubRequest;
import com.dev.Efoot.controller.response.ClubDetailResponse;
import com.dev.Efoot.controller.response.ClubResponse;
import com.dev.Efoot.controller.response.StadiumResponse;
import com.dev.Efoot.entity.Club;
import com.dev.Efoot.entity.Stadium;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-06-26T11:41:03-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 17.0.16 (Microsoft)"
)
@Component
public class ClubMapperImpl implements ClubMapper {

    @Override
    public ClubResponse toClubResponse(Club club) {
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

    @Override
    public ClubDetailResponse toClub(Club club) {
        if ( club == null ) {
            return null;
        }

        ClubDetailResponse clubDetailResponse = new ClubDetailResponse();

        clubDetailResponse.setId( club.getId() );
        clubDetailResponse.setName( club.getName() );
        clubDetailResponse.setFounded( club.getFounded() );
        clubDetailResponse.setUrlImg( club.getUrlImg() );
        clubDetailResponse.setStadium( stadiumToStadiumResponse( club.getStadium() ) );

        return clubDetailResponse;
    }

    @Override
    public Club toEntity(CreateClubRequest request) {
        if ( request == null ) {
            return null;
        }

        Club.ClubBuilder club = Club.builder();

        club.stadium( createClubRequestToStadium( request ) );
        club.name( request.getName() );
        club.founded( request.getFounded() );
        club.urlImg( request.getUrlImg() );

        return club.build();
    }

    protected StadiumResponse stadiumToStadiumResponse(Stadium stadium) {
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

    protected Stadium createClubRequestToStadium(CreateClubRequest createClubRequest) {
        if ( createClubRequest == null ) {
            return null;
        }

        Stadium.StadiumBuilder stadium = Stadium.builder();

        stadium.id( createClubRequest.getStadiumId() );

        return stadium.build();
    }
}
