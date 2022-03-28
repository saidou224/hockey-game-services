package com.sba.hockeyGame.data;

import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.model.Player;
import com.sba.hockeyGame.domain.model.Team;
import java.util.List;

public class TestData {

  public static String SEARCH_TEAM_URL = "/team/%s";
  public static final String TEAM_YEAR = "2020";

  public static Team buildTeamWithPlayers() {
    Player player = Player.builder()
        .id(Long.valueOf(3))
        .isCaptain(true)
        .name("Michel")
        .lastName("Jordan")
        .number(Long.valueOf(8))
        .position("Defender")
        .build();

    return Team.builder()
        .id(Long.valueOf(2))
        .coach("Marc James")
        .year(Long.valueOf(2020))
        .players(List.of(player))
        .build();
  }

  public static TeamResponseDto buildTeamResponseWithPlayers() {
    PlayerDto player = PlayerDto.builder()
            .isCaptain(true)
            .name("Michel")
            .lastname("Jordan")
            .number(Long.valueOf(8))
            .position("Defender")
            .build();

    return TeamResponseDto.builder()
            .id(Long.valueOf(2))
            .coach("Marc James")
            .year(Long.valueOf(2020))
            .players(List.of(player))
            .build();
  }
}
