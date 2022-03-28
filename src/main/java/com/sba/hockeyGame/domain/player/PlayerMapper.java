package com.sba.hockeyGame.domain.player;

import com.sba.hockeyGame.domain.dto.PlayerDto;
import com.sba.hockeyGame.domain.dto.PlayerAddedDto;
import com.sba.hockeyGame.domain.model.Player;
import java.util.Optional;
import org.springframework.stereotype.Component;


@Component
public class PlayerMapper {

    public Player map(PlayerDto playerDto) {
        return Optional.ofNullable(playerDto)
                .map(
                        dto -> Player
                                .builder()
                                .name(dto.getName())
                                .lastName(dto.getLastname())
                                .number(dto.getNumber())
                                .position(dto.getPosition())
                                .isCaptain(dto.isCaptain())
                                .build()
                ).orElse(null);
    }

  public PlayerAddedDto mapToAddedPLayer(Player player) {
    return Optional.ofNullable(player)
        .map(
            play -> PlayerAddedDto
                .builder()
                .id(player.getId())
                .name(play.getName())
                .lastname(play.getLastName())
                .number(play.getNumber())
                .position(play.getPosition())
                .isCaptain(play.getIsCaptain())
                .build()
        ).orElse(null);
  }

    public PlayerDto mapToPlayerDto(Player player) {
        return Optional.ofNullable(player)
                .map(
                        t -> PlayerDto.builder()
                                .number(player.getNumber())
                                .name(player.getName())
                                .lastname(player.getLastName())
                                .isCaptain(player.getIsCaptain())
                                .position(player.getPosition())
                                .build())
                .orElse(null);
    }

}
