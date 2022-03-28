package com.sba.hockeyGame.domain.services;

import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.PlayerAddedDto;
import com.sba.hockeyGame.domain.model.Player;
import com.sba.hockeyGame.domain.model.Team;

import java.util.List;
import javax.management.InstanceAlreadyExistsException;

public interface PlayerService {

  Player makePlayerCaptain(final Long playerId) throws InstanceAlreadyExistsException;

  List<Player> getPlayers(final int page, final int size);

  PlayerAddedDto addPlayer(Team team, PlayerDto playerDto);
}
