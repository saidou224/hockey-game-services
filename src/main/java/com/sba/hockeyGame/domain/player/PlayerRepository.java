package com.sba.hockeyGame.domain.player;

import com.sba.hockeyGame.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
