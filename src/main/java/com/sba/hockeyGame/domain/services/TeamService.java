package com.sba.hockeyGame.domain.services;

import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.dto.TeamToAddDto;
import com.sba.hockeyGame.domain.model.Team;
import java.util.List;

public interface TeamService {

  void addTeam(TeamToAddDto teamDto);

  List<Team> getTeams(final int pageNumber, final int pageSize);

  Team findTeamByYear(Long year);

  List<TeamResponseDto> getTeamsByYear(Long year, int pageNumber, int pageSize);
}
