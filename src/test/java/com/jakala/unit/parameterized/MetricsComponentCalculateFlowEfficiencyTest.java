package com.jakala.unit.parameterized;

import com.jakala.unit.simple.parameterized.Activity;
import com.jakala.unit.simple.parameterized.MetricsComponent;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MetricsComponentCalculateFlowEfficiencyTest {

    private MetricsComponent target;

    private final FlowEfficiencyWrapper flowEfficiencyWrapper;

    @Parameterized.Parameters
    public static Collection<FlowEfficiencyWrapper> input() {

        return Arrays.asList(
                new FlowEfficiencyWrapper(10L, 10L, new BigDecimal("0")),
                new FlowEfficiencyWrapper(10L, 0L, new BigDecimal("1")),
                new FlowEfficiencyWrapper(10L, 9L, new BigDecimal("0.1"))
        );

    }

    public MetricsComponentCalculateFlowEfficiencyTest(FlowEfficiencyWrapper flowEfficiencyWrapper) {
        this.flowEfficiencyWrapper = flowEfficiencyWrapper;
    }

    @Before
    public void setUp() {
        target = new MetricsComponent();
    }

    @Test
    public void computeFlowEfficiency() {
        Activity a = new Activity();
        a.setLeadTime(flowEfficiencyWrapper.getLeadTime());
        a.setHowManyDaysWasBlocked(flowEfficiencyWrapper.getBlockedDays());
        BigDecimal flowEfficiency = target.calculateFlowEfficiency(a);
        Assertions.assertThat(flowEfficiency).isEqualByComparingTo(flowEfficiencyWrapper.getExpectedFlowEfficiency());
    }

    private static class FlowEfficiencyWrapper {
        private Long leadTime;
        private Long blockedDays;
        private BigDecimal expectedFlowEfficiency;

        public FlowEfficiencyWrapper(Long leadTime, Long blockedDays, BigDecimal expectedFlowEfficiency) {
            this.leadTime = leadTime;
            this.blockedDays = blockedDays;
            this.expectedFlowEfficiency = expectedFlowEfficiency;
        }

        public Long getLeadTime() {
            return leadTime;
        }

        public Long getBlockedDays() {
            return blockedDays;
        }

        public BigDecimal getExpectedFlowEfficiency() {
            return expectedFlowEfficiency;
        }
    }
}
