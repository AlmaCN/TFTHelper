package com.cnade.betfthelper.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchDTOIn {
    private boolean victory;
    private int lpMatch;
    private String compName;
    private String playerName;
}
