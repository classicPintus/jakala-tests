package com.jakala.unittests;

import java.time.Duration;
import java.time.LocalDate;

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
};