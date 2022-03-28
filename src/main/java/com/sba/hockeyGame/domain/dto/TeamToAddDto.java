package com.sba.hockeyGame.domain.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamToAddDto {

  private String coach;
  private Long year;
}
