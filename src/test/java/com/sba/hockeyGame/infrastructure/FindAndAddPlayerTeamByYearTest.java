package com.sba.hockeyGame.infrastructure;

import static com.sba.hockeyGame.data.TestData.SEARCH_TEAM_URL;
import static com.sba.hockeyGame.data.TestData.TEAM_YEAR;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.sba.hockeyGame.api.infrastructure.ApiDelegate;
import com.sba.hockeyGame.api.web.TeamController;
import com.sba.hockeyGame.config.MockMvcConfiguration;
import com.sba.hockeyGame.data.TestData;
import com.sba.hockeyGame.domain.dto.TeamResponseDto;
import com.sba.hockeyGame.domain.model.Team;
import com.sba.hockeyGame.domain.services.PlayerService;
import com.sba.hockeyGame.domain.services.TeamService;
import com.sba.hockeyGame.api.infrastructure.impl.ApiDelegateImpl;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(TeamController.class)
@ActiveProfiles("test")
@Import(MockMvcConfiguration.class)
public class FindAndAddPlayerTeamByYearTest {

	private ApiDelegate apiDelegate;
	@MockBean
	private TeamService teamService;
	@MockBean
	private PlayerService playerService;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
	  this.apiDelegate = new ApiDelegateImpl(teamService, playerService);
	}

	@Test
	void whenFindTeamByYear_givenEmptyResult_thenReturnEmptyList() throws Exception {
		final String url = String.format(SEARCH_TEAM_URL, TEAM_YEAR);

		this.mockMvc
				.perform(
						get(url)
						.accept(APPLICATION_JSON)
						.contentType(APPLICATION_JSON))
				.andExpect(status().isPartialContent())
				.andExpect(jsonPath("$", is(Collections.EMPTY_LIST)));
	}

	@Test
	void whenFindTeamByYear_givenTeamRelatedYear_thenReturnListWithRelatedTeamAndPlayers()
			throws Exception {
		final String url = String.format(SEARCH_TEAM_URL, TEAM_YEAR);
		final Team team = TestData.buildTeamWithPlayers();
		final List<TeamResponseDto> teamList = List.of(TestData.buildTeamResponseWithPlayers());

		given(teamService.findTeamByYear(Long.valueOf(TEAM_YEAR)))
				.willReturn(team);
		given(teamService.getTeamsByYear(Long.valueOf(TEAM_YEAR), 0, 20))
				.willReturn(teamList);

		this.mockMvc
				.perform(get(url).accept(APPLICATION_JSON).contentType(APPLICATION_JSON))
				.andDo(print())
				.andExpect(status().isPartialContent())
				.andExpect(jsonPath("$[0].coach", is(team.getCoach())));
	}
}
