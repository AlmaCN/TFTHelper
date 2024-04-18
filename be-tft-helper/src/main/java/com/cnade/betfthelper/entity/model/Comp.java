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
@Table(name = "comp")
public class Comp {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "comp_id")
    private Integer compId;
    @Column(name = "comp_name")
    private String compName;
    @Column(name = "start_champ_1")
    private String startChamp1;
    @Column(name = "start_champ_2")
    private String startChamp2;
    @Column(name = "start_champ_3")
    private String startChamp3;
    @Column(name = "start_champ_4")
    private String startChamp4;
    @Column(name = "is_active_on_m")
    private boolean isActiveOnM;
    @Column(name = "wins")
    private int wins;
    @Column(name = "tier")
    private char tier;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "playerId")
    private Player player;
    @OneToMany(mappedBy = "comp")
    @ToString.Exclude
    List<Match> matches;
}
