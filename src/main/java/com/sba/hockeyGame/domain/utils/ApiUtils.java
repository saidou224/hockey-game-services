package com.sba.hockeyGame.domain.utils;

import com.sba.hockeyGame.domain.model.Player;
import java.util.List;
import javax.management.InstanceAlreadyExistsException;

public class ApiUtils {

  public static void checkTeamCaptainAlreadyExist(final Long yearOfTeam, final boolean isCaptain, final List<Player> players)
      throws InstanceAlreadyExistsException {
    if (isCaptain &&
        players.stream()
            .anyMatch(Player::getIsCaptain)) {
      throw new InstanceAlreadyExistsException("The " + yearOfTeam + " team already have captain");
    }
  }

  public static void checkPlayerNumberAlreadyExist(final Long yearOfTeam, final Long playerNumber, final List<Player> players)
      throws InstanceAlreadyExistsException {
    if (players.stream()
        .anyMatch(player -> playerNumber == player.getNumber())) {
      throw new InstanceAlreadyExistsException("The " + yearOfTeam + " team already have player with number " + playerNumber);
    }
  }

}
