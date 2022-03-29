package com.sba.hockeyGame.domain.services.impl;

import com.sba.hockeyGame.domain.dto.PlayerAddedDto;
import com.sba.hockeyGame.domain.dto.PlayerDto;
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
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Log4j2
public class PlayerServiceImpl implements PlayerService {

  private final PlayerCommand playerCommand;
  private final PlayerMapper playerMapper;
  private final PlayerQuery playerQuery;

  @Transactional
  @Override
  public Player makePlayerCaptain(Long playerId) throws InstanceAlreadyExistsException {
    log.info("make player with {} as captain", playerId);
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
    log.info("retrieve list of player");
    return playerQuery.retrieveAllPlayers(page, size).getContent();
  }

  @Transactional
  @Override
  public PlayerAddedDto addPlayer(final Team team, PlayerDto playerDto) {
    log.info("add player {} to team {}", playerDto, team.getYear());
    Player player = playerMapper.map(playerDto);
    player.setTeam(team);
    return playerMapper.mapToAddedPLayer(playerCommand.savePlayer(player));
  }
}
