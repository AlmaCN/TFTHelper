package com.cnade.betfthelper.entity.dto;

import com.cnade.betfthelper.entity.model.Comp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchWithCompsDTOOut {
    private boolean victory;
    private Comp comp;
}
