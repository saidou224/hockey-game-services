package com.sba.hockeyGame.domain.services.impl;

import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.PlayerAddedDto;
import com.sba.hockeyGame.domain.model.Player;
import com.sba.hockeyGame.domain.model.Team;
import com.sba.hockeyGame.domain.player.PlayerCommand;
import com.sba.hockeyGame.domain.player.PlayerMapper;
import com.sba.hockeyGame.domain.player.PlayerQuery;
import com.sba.hockeyGame.domain.services.PlayerService;
import com.sba.hockeyGame.domain.utils.ApiUtils;
import java.util.List;
import java.util.NoSuchElementException;

import javax.management.InstanceAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlayerServiceImpl implements PlayerService {

  private final PlayerCommand playerCommand;
  private final PlayerMapper playerMapper;
  private final PlayerQuery playerQuery;


  @Override
  public Player makePlayerCaptain(Long playerId) throws InstanceAlreadyExistsException {


    Player player = playerQuery.findById(playerId)
            .orElseThrow(() -> new NoSuchElementException(
                    "A player with id " + playerId + " not found in database"));

    Team playerTeam = player.getTeam();
    ApiUtils.checkTeamCaptainAlreadyExist(playerTeam.getYear(), true, playerTeam.getPlayers());
    player.setIsCaptain(true);
    return playerCommand.savePlayer(player);
  }

  @Override
  public List<Player> getPlayers(final int page, final int size) {
    return playerQuery.retrieveAllPlayers(page, size).getContent();
  }

  @Override
  public PlayerAddedDto addPlayer(final Team team, PlayerDto playerDto) {
    Player player = playerMapper.map(playerDto);
    player.setTeam(team);
    return playerMapper.mapToAddedPLayer(playerCommand.savePlayer(player));
  }
}
