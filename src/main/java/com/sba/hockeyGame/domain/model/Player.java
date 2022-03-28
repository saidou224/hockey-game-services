package com.sba.hockeyGame.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "player")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "number", nullable = false)
  private Long number;

  @Column(name = "firstName", nullable = false)
  private String name;

  @Column(name = "lastName", nullable = false)
  private String lastName;

  @Column(name = "position", nullable = false)
  private String position;

  @Column(name = "isCaptain", nullable = false)
  private Boolean isCaptain;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "teamId", nullable = false)
  @JsonBackReference
  private Team team;
}
