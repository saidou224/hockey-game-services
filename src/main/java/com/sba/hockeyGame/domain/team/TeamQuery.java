package com.sba.hockeyGame.domain.team;

import com.sba.hockeyGame.domain.model.Team;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamQuery {

  private final TeamRepository teamRepository;

  public Page<Team> retrieveTeams(final int page, final int size) {
    return teamRepository.findAll(PageRequest.of(page, size));
  }

    public Page<Team> retrieveTeamsByYear(Long year, int pageNumber, int pageSize) {
      Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
      return teamRepository.findAllByYear(year, pageRequest);
    }

  public Optional<Team> findTeamByYear(Long year) {
    return teamRepository.findByYear(year);
  }
}
