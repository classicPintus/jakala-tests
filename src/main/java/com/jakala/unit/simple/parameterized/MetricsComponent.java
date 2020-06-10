package com.jakala.unit.simple.parameterized;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MetricsComponent {

    public BigDecimal calculateFlowEfficiency(final Activity activity) {
        BigDecimal leadTime = BigDecimal.valueOf(activity.getLeadTime());
        BigDecimal blockedDays = BigDecimal.valueOf(activity.getHowManyDaysWasBlocked());

        BigDecimal numerator = leadTime.subtract(blockedDays);

        return numerator.divide(leadTime, 2, RoundingMode.HALF_UP);
    }
}
