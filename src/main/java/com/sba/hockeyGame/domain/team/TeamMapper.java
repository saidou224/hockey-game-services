package com.sba.hockeyGame.domain.team;

import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.dto.TeamToAddDto;
import com.sba.hockeyGame.domain.model.Player;
import com.sba.hockeyGame.domain.model.Team;

import java.util.Optional;

import com.sba.hockeyGame.domain.player.PlayerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TeamMapper {

  private final PlayerMapper playerMapper;

  public Team map(TeamToAddDto teamDto) {
    return Optional.ofNullable(teamDto)
        .map(
            dto -> Team.builder()
                    .coach(teamDto.getCoach())
                    .year(teamDto.getYear())
                    .build())
        .orElse(null);
  }

  public TeamResponseDto map(Team team) {
    return Optional.ofNullable(team)
            .map(
                    t -> TeamResponseDto.builder()
                            .id(team.getId())
                            .coach(team.getCoach())
                            .year(team.getYear())
                            .players(t.getPlayers().stream().map(playerMapper::mapToPlayerDto).toList())
                            .build())
            .orElse(null);
  }

}
