package com.cnade.betfthelper.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTOIn {
    private String name;
    private String league;
    private int leagueTier;
    private int lp;
}
