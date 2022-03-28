package com.sba.hockeyGame.api.infrastructure;

import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.PlayerAddedDto;
import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.dto.TeamToAddDto;
import com.sba.hockeyGame.domain.model.Player;
import com.sba.hockeyGame.domain.model.Team;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ApiDelegate {

    ResponseEntity <PlayerAddedDto> addPlayerToTeam(final Long yearOfTeam, final PlayerDto playerDto) throws InstanceAlreadyExistsException;

    ResponseEntity <List<Team>> getTeams(final int pageNumber, final int pageSize);

    ResponseEntity<List<TeamResponseDto>> getTeamsByYear(final Long year, final int pageNumber, int pageSize);

    void addTeam(final TeamToAddDto teamDto);

    ResponseEntity <List<Player>> getPlayers(final int page, int size);

    ResponseEntity <Player> makePlayerCaptain(final Long idPlayer) throws InstanceAlreadyExistsException;
}
