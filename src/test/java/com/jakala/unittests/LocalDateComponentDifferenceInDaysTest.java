package com.jakala.unittests;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateComponentDifferenceInDaysTest extends BaseUnitTest {

    private LocalDateComponent target;

    @Before
    public void setUp() {
        target = new LocalDateComponent();
    }

    @Test
    public void shouldBeOnlyOneDayOfDifference() {

        LocalDate from = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate to = LocalDate.of(2019, Month.JANUARY, 2);

        long differenceInDays = target.differenceInDays(from, to);

        Assertions.assertThat(differenceInDays).isEqualTo(1L);
    }

    @Test
    public void shouldHaveNoDifferenceBecauseIsTheSameDate() {

        LocalDate from = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate to = from;

        long differenceInDays = target.differenceInDays(from, to);

        Assertions.assertThat(differenceInDays).isEqualTo(0L);
    }

    @Test
    public void shouldHaveOneYearOfDifference() {

        LocalDate from = LocalDate.of(2019, Month.JANUARY, 1);
        LocalDate to = LocalDate.of(2020, Month.JANUARY, 1);

        long differenceInDays = target.differenceInDays(from, to);

        Assertions.assertThat(differenceInDays).isEqualTo(365L);
    }

    @Test
    public void shouldHaveOneYearOfDifferenceInCaseOfLeapYear() {

        LocalDate from = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate to = LocalDate.of(2021, Month.JANUARY, 1);

        long differenceInDays = target.differenceInDays(from, to);

        Assertions.assertThat(differenceInDays).isEqualTo(366L);
    }

    @Test
    public void shouldManageFromAfterTo() {
        LocalDate from = LocalDate.of(2021, Month.JANUARY, 1);
        LocalDate to = LocalDate.of(2020, Month.JANUARY, 1);

        long differenceInDays = target.differenceInDays(from, to);

        Assertions.assertThat(differenceInDays).isEqualTo(366L);
    }

    @Test
    public void shouldRaiseExceptionBecauseFromIsNull() {
        LocalDate from = null;
        LocalDate to = LocalDate.of(2020, Month.JANUARY, 1);

        Assertions.assertThatThrownBy(() -> target.differenceInDays(from, to)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldRaiseExceptionBecauseToIsNull() {
        LocalDate from = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate to = null;

        Assertions.assertThatThrownBy(() -> target.differenceInDays(from, to)).isInstanceOf(NullPointerException.class);
    }

    @Test
    public void shouldRaiseExceptionBecauseAllDatesAreNull() {
        LocalDate from = null;
        LocalDate to = null;

        Assertions.assertThatThrownBy(() -> target.differenceInDays(from, to)).isInstanceOf(NullPointerException.class);
    }
}