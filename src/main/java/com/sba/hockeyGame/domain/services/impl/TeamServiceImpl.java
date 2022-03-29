package com.sba.hockeyGame.domain.services.impl;

import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.dto.TeamToAddDto;
import com.sba.hockeyGame.domain.model.Team;
import com.sba.hockeyGame.domain.services.TeamService;
import com.sba.hockeyGame.domain.team.TeamCommand;
import com.sba.hockeyGame.domain.team.TeamMapper;
import com.sba.hockeyGame.domain.team.TeamQuery;
import java.util.List;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class TeamServiceImpl implements TeamService {

  private final TeamCommand teamCommand;
  private final TeamMapper teamMapper;
  private final TeamQuery teamQuery;

  @Transactional
  @Override
  public void addTeam(TeamToAddDto teamDto) {
    teamCommand.save(teamMapper.map(teamDto));
    log.info("team {} have been saved", teamDto);
  }

  @Override
  public List<Team> getTeams(int pageNumber, int pageSize) {
    log.info("retrieve list of team");
    return teamQuery.retrieveTeams(pageNumber, pageSize).getContent();
  }

  @Override
  public Team findTeamByYear(Long year) {
    log.info("retrieve a team for year {}", year);
    return teamQuery.findTeamByYear(year)
            .orElseThrow(() -> new NoSuchElementException(
                    "A team with year " + year + " not found in database"));
  }

  @Override
  public List<TeamResponseDto> getTeamsByYear(Long year, int pageNumber, int pageSize) {
    log.info("retrieve list of team");
    return teamQuery.retrieveTeamsByYear(year, pageNumber, pageSize).getContent()
            .stream()
            .map(teamMapper::map)
            .toList();
  }


}
