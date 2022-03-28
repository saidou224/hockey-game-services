package com.sba.hockeyGame.domain.team;

import com.sba.hockeyGame.domain.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Page<Team> findAllByYear(Long year, Pageable pageRequest);
    Optional<Team> findByYear(Long year);
}
