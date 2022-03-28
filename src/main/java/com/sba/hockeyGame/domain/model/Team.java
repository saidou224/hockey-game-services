package com.sba.hockeyGame.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "team")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "coach", nullable = false)
  private String coach;

  @Column(name = "year", nullable = false, unique = true)
  private Long year;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "team", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Player> players;

}
