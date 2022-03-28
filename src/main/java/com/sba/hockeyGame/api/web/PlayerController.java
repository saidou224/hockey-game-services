package com.sba.hockeyGame.api.web;

import com.sba.hockeyGame.domain.model.Player;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

import com.sba.hockeyGame.api.infrastructure.ApiDelegate;
import javax.management.InstanceAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
@RequiredArgsConstructor
public class PlayerController {

    private final ApiDelegate apiDelegate;

    @GetMapping
    public ResponseEntity<List<Player>> players(
        @RequestParam(defaultValue = "0") final int page,
        @RequestParam(defaultValue = "20") final int size) {
        return apiDelegate.getPlayers(page, size);
    }

    @Operation(description = "Make player captain")
    @PutMapping("/captain/{idPlayer}")
    public ResponseEntity<Player> makePlayerCaptain(
            @PathVariable final Long idPlayer) throws InstanceAlreadyExistsException {
        return apiDelegate.makePlayerCaptain(idPlayer);
    }

}