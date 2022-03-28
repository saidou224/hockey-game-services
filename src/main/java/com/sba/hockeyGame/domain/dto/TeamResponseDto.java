package com.sba.hockeyGame.domain.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TeamResponseDto {

  private Long id;
  private String coach;
  private Long year;
  private List<PlayerDto> players;
}
