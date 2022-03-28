package com.sba.hockeyGame.domain.team;

import com.sba.hockeyGame.domain.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamCommand {

  private final TeamRepository teamRepository;

  public void save(Team team) {
    teamRepository.save(team);
  }

}
