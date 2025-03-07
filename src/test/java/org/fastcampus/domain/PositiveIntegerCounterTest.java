package org.fastcampus.domain;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositiveIntegerCounterTest {


    @Test
    void givenCreated_whenIncrease_thenCountIsOne() {
        // given
        PositiveIntegerCounter counter = new PositiveIntegerCounter();


        //when
        counter.increase();


        // then
        Assertions.assertEquals(1,counter.getCount());
    }

    @Test
    void givenCreatedAndIncreased_whenDecrease_thenCountIsZero() {
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        counter.increase();

        counter.decrease();

        Assertions.assertEquals(0, counter.getCount());
    }

    @Test
    void givenCreated_whenDecrease_thenCountIsZero() {
        PositiveIntegerCounter counter = new PositiveIntegerCounter();

        counter.increase();

        counter.decrease();
        counter.decrease();

        Assertions.assertEquals(0, counter.getCount());
    }

}
