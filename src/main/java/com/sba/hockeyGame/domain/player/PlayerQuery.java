package com.sba.hockeyGame.domain.player;

import com.sba.hockeyGame.domain.model.Player;
import com.sba.hockeyGame.domain.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerQuery {

  private final PlayerRepository playerRepository;

  public Optional<Player> findById(Long idPlayer) {
    return playerRepository.findById(idPlayer);
  }

  public Page<Player> retrieveAllPlayers(final int page, final int size) {
    return playerRepository.findAll(PageRequest.of(page, size));
  }
}
