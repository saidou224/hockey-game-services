package com.sba.hockeyGame.domain.player;

import com.sba.hockeyGame.domain.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerCommand {

  private final PlayerRepository playerRepository;

  public Player savePlayer(Player player) {
    return playerRepository.save(player);
  }
}
