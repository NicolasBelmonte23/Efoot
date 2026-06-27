package com.dev.Efoot.service;

import com.dev.Efoot.controller.request.CreateClubRequest;
import com.dev.Efoot.controller.response.ClubDetailResponse;
import com.dev.Efoot.entity.Club;
import com.dev.Efoot.mapper.ClubMapper;
import com.dev.Efoot.repository.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CreateClubService {
    private final ClubRepository clubRepository;
    private final ClubMapper mapper;
    private final FindStadiumService findStadiumService;

   public ClubDetailResponse execute(CreateClubRequest request){
       Club entity = mapper.toEntity(request);
       if(Objects.nonNull(entity.getStadium())){
           entity.setStadium(findStadiumService.findById(entity.getStadium().getId()));
       }
       Club newClub = clubRepository.save(entity);
       return mapper.toClubDetailResponse(newClub);
   }
}
