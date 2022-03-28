package com.sba.hockeyGame.api.infrastructure.impl;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.PARTIAL_CONTENT;

import com.sba.hockeyGame.api.infrastructure.ApiDelegate;
import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.PlayerAddedDto;
import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.dto.TeamToAddDto;
import com.sba.hockeyGame.domain.model.Player;
import com.sba.hockeyGame.domain.model.Team;
import com.sba.hockeyGame.domain.services.PlayerService;
import com.sba.hockeyGame.domain.services.TeamService;
import com.sba.hockeyGame.domain.utils.ApiUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiDelegateImpl implements ApiDelegate {

    private final TeamService teamService;
    private final PlayerService playerService;

    @Override
    public ResponseEntity<PlayerAddedDto> addPlayerToTeam(final Long yearOfTeam, final PlayerDto playerDto)
            throws InstanceAlreadyExistsException {
        Team team = teamService.findTeamByYear(yearOfTeam);

        List<Player> teamPlayers = team.getPlayers();
        ApiUtils.checkTeamCaptainAlreadyExist(yearOfTeam, playerDto.isCaptain(), teamPlayers);
        ApiUtils.checkPlayerNumberAlreadyExist(yearOfTeam, playerDto.getNumber(), teamPlayers);

        return new ResponseEntity(playerService.addPlayer(team, playerDto), CREATED);
    }



    public ResponseEntity <List<Team>> getTeams(final int pageNumber, final int pageSize) {
        return new ResponseEntity(teamService.getTeams(pageNumber, pageSize), PARTIAL_CONTENT);
    }

    @Override
    public ResponseEntity<List<TeamResponseDto>> getTeamsByYear(final Long year, final int pageNumber, final int pageSize) {
        return new ResponseEntity(teamService.getTeamsByYear(year, pageNumber, pageSize), PARTIAL_CONTENT);
    }

    @Override
    public void addTeam(TeamToAddDto teamDto) {
        teamService.addTeam(teamDto);
    }

    @Override
    public ResponseEntity <List<Player>> getPlayers(final int page, final int size) {
        return new ResponseEntity(playerService.getPlayers(page, size), PARTIAL_CONTENT);
    }

    @Override
    public ResponseEntity <Player> makePlayerCaptain(final Long idPlayer) throws InstanceAlreadyExistsException {
        return ResponseEntity.ok(playerService.makePlayerCaptain(idPlayer)) ;
    }
}
