package org.fastcampus.post.doamin.common;

import org.fastcampus.post.domain.common.DatetimeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class DatetimeInfoTest {


    @Test
    void givenCreated_whenUpdated_thenTimeIsStateArsUpdated() {
        //given
        DatetimeInfo datetimeInfo = new DatetimeInfo();
        LocalDateTime localDateTime = datetimeInfo.getDatetime();

        System.out.println(localDateTime);

        //when
        datetimeInfo.updateEditDatetime();

        //then
        Assertions.assertTrue(datetimeInfo.isEdited());
        Assertions.assertNotEquals(localDateTime, datetimeInfo.getDatetime());

        System.out.println(datetimeInfo.getDatetime());
    }



}
