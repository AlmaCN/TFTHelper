package com.cnade.betfthelper.entity.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "match_id")
    private Integer matchId;
    @Column(name = "victory")
    private boolean victory;
    @Column(name = "lp_match")
    private int lpMatch;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "compId")
    private Comp comp;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "playerId")
    private Player player;
}
