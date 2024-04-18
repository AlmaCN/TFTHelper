package com.cnade.betfthelper.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "player_id")
    private Integer playerId;
    @Column(name = "player_name", unique = true)
    private String playerName;
    @Column(name = "league")
    private String league;
    @Column(name = "league_tier")
    private int leagueTier;
    @Column(name = "lp_player")
    private int lpPlayer;
    @Column(name = "match_counter")
    private int matchCounter;
    @OneToMany(mappedBy = "player")
    @ToString.Exclude
    private List<Comp> comps;
    @JsonIgnore
    @OneToMany(mappedBy = "player")
    @ToString.Exclude
    private List<Match> matches;

}
