package com.cnade.betfthelper.entity.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompResource {
    private String compName;
    private List<String> startChamps;
    private boolean isActiveOnM;
    private int wins;
    private char tier;
}
