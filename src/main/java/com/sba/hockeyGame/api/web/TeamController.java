package com.sba.hockeyGame.api.web;

import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.PlayerAddedDto;
import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.dto.TeamToAddDto;
import com.sba.hockeyGame.domain.model.Team;

import java.util.List;

import com.sba.hockeyGame.api.infrastructure.ApiDelegate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/team")
@RequiredArgsConstructor
public class TeamController {

    private final ApiDelegate apiDelegate;

    @Operation(description = "retrieve list of the first page number elements")
    @GetMapping
    public ResponseEntity<List<Team>> teams(
        @RequestParam(defaultValue = "0") final int pageNumber,
        @RequestParam(defaultValue = "20") final int pageSize) {
        return apiDelegate.getTeams(pageNumber, pageSize);
    }

    @Operation(description = "retrieve list of team by year ")
    @GetMapping("/{year}")
    public ResponseEntity<List<TeamResponseDto>> getTeamByYear(
            @PathVariable final Long year,
            @RequestParam(defaultValue = "0", required = false) final int pageNumber,
            @RequestParam(defaultValue = "20", required = false) final int pageSize) {
        return apiDelegate.getTeamsByYear(year, pageNumber, pageSize);
    }

    @Operation(description = "add a team to the DB")
    @ApiResponses( value = {
        @ApiResponse(responseCode = "201", description = "the team have been created"),
    })
    @PostMapping
    public ResponseEntity<?> create(@RequestBody final TeamToAddDto teamDto) {
        apiDelegate.addTeam(teamDto);
        return ResponseEntity.status(CREATED).build();
    }

    @Operation(description = "add a player to an existing team year")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "the player have been created and added to the team"),
            @ApiResponse(responseCode = "409", description = "There is already a captain for that team")
    })
    @PostMapping("/{year}")
    public ResponseEntity<PlayerAddedDto> addPlayerToTeam(
            @PathVariable final Long year,
            @RequestBody final PlayerDto playerDto) throws InstanceAlreadyExistsException {

            return apiDelegate.addPlayerToTeam(year, playerDto);

    }

}