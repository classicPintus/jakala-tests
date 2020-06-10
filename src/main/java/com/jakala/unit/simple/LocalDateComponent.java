package com.jakala.unit.simple;

import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDate;

@Component
public class LocalDateComponent {

    /**
     * @param from starting date
     * @param to   ending date
     * @return difference in days
     * @throws NullPointerException when from or to are null
     */
    public long differenceInDays(LocalDate from, final LocalDate to) {
        return Duration.between(from.atStartOfDay(), to.atStartOfDay()).abs().toDays();
    }
}