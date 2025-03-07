package org.fastcampus.user.application;

import org.fastcampus.user.application.dto.CreateUserRequestDto;
import org.fastcampus.user.application.dto.FollowUSerRequestDto;
import org.fastcampus.user.application.interfases.UserRelationRepository;
import org.fastcampus.user.application.interfases.UserRepository;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.repository.FakeUSerRelationRepository;
import org.fastcampus.user.repository.FakeUSerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserRelationServiceTest {


    private final UserRepository userRepository = new FakeUSerRepository();
    private final UserService userService = new UserService(userRepository);
    private final UserRelationRepository userRelationRepository = new FakeUSerRelationRepository();
    private final UserRelationService userRelationService = new UserRelationService(userService, userRelationRepository);

    private User user1;
    private User user2;

    private FollowUSerRequestDto requestDto;
    @BeforeEach
    void init() {
        CreateUserRequestDto dto = new CreateUserRequestDto("test","");
        this.user1 = userService.createUser(dto);
        this.user2 = userService.createUser(dto);

        this.requestDto = new FollowUSerRequestDto(user1.getId(), user2.getId());
    }


    @Test
    void givenCreateTwoUser_whenFollow_thenUserFollowSaved() {
        //when
        userRelationService.follow(requestDto);


        //then
        Assertions.assertEquals(1,user1.followingCount());
        Assertions.assertEquals(1,user2.followerCount());
    }

    @Test
    void givenCreateTwoUser_whenUnfollow_thenUserUnfollowSaved() {
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(requestDto));
    }

    @Test
    void givenCreateTwoFollowerUser_whenFollow_thenUserFollowSaved() {
        //given
        FollowUSerRequestDto sameUser = new FollowUSerRequestDto(user1.getId(), user1.getId());

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> userRelationService.unfollow(sameUser));
    }


}
