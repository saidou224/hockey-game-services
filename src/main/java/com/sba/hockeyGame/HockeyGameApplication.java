package com.sba.hockeyGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HockeyGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(HockeyGameApplication.class, args);
	}

/*	@Bean
	CommandLineRunner apiRunner (ApiDelegate apiDelegate) {
		return args -> {
			apiDelegate.addTeam(TeamToAddDto.builder().coach("User user").year(2021L).build());
			apiDelegate.addTeam(TeamToAddDto.builder().coach("SBA BARRY").year(2020L).build());
			apiDelegate.addTeam(TeamToAddDto.builder().coach("Claude Julien").year(2022L).build());


			apiDelegate.addPlayerToTeam(2021L,
					PlayerDto.builder().number(10L)
					.name("player").lastname("p1").position("denfense").build());

			apiDelegate.addPlayerToTeam(2021L,
					 PlayerDto.builder().number(9L).name("player2")
					.lastname("p2").position("attaque").build());

			apiDelegate.addPlayerToTeam(2020L,
					PlayerDto.builder().number(8L).name("player3").lastname("p3").position("goal").isCaptain(true).build());

			apiDelegate.addPlayerToTeam(2020L,
					PlayerDto.builder().number(10L)
					.name("player").lastname("p4").position("denfense").build());

			apiDelegate.addPlayerToTeam(2022L,
					PlayerDto.builder().number(9L).name("player2")
					.lastname("p5").position("attaque").build());
			apiDelegate.addPlayerToTeam(2022L,
					PlayerDto.builder().number(8L).name("Mark").lastname("Barberio").position("DEFENCE").build());
			apiDelegate.addPlayerToTeam(2022L,
					PlayerDto.builder().number(7L).name("player").lastname("p5").position("goal").build());
		};
	}
*/
}
