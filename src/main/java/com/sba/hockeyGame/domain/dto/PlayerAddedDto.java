package com.sba.hockeyGame.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerAddedDto {
  private Long id;
  private Long number;
  private String name;
  private String lastname;
  private String position;
  private boolean isCaptain;
}
