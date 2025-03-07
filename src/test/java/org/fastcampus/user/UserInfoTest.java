package org.fastcampus.user;

import org.fastcampus.user.domain.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserInfoTest {

    @Test
    void givenNameAndProfileImage_whenCreated_thenThrowNothing() {
        //given
        String name = "abcd";
        String profileImageUrl = "";

        // when
        UserInfo userInfo = new UserInfo(name, profileImageUrl);

        //then
        Assertions.assertDoesNotThrow(() -> new UserInfo(name, profileImageUrl));

    }
}
