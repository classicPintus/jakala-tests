package com.jakala.unit.simple.parameterized;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Activity {

    private Long leadTime;
    private Long howManyDaysWasBlocked = 0L;
}
