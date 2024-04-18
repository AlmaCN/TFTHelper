package com.cnade.betfthelper.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerResource {
    private String playerName;
    private String league;
    private int lpPlayer;
    private List<CompResource> comps;
}
