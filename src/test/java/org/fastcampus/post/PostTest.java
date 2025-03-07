package org.fastcampus.post;

import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.post.domain.content.PostPublication;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostTest {

    private final UserInfo info = new UserInfo("name","url");
    private final User user = new User(1L,info);
    private final User otherUser = new User(2L, info);

    private final Post post = new Post(1L, user, new PostContent("content"));


    @Test
    void givenPostCreatedWhenLikeThenLikeCountShouldBe1() {
        //when
        post.like(otherUser);

        //then
        Assertions.assertEquals(1,post.getLikeCount());

    }

    @Test
    void givenPostCreate_whenLikeByOtherUser_thenThrowException() {
        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> post.like(user));
        System.out.println(post.getAuthor());
        System.out.println(user);

    }

    @Test
    void givenPostCreateAndLike_whenUnlike_thenLikeCountAShouldBe0() {
        //given
        post.like(otherUser);

        //when
        post.unlike();

        //then
        Assertions.assertEquals(0,post.getLikeCount());
    }

    @Test
    void givenPostCreated_whenUpdateContent_thenContentShouldBeUpdated() {
        //given
        String newPostContent = "new content";
        System.out.println(post.getContent().getContentText());
        //when
        post.updatePost(user, newPostContent, PostPublication.PUBLIC);
        System.out.println(post.getContent().getContentText());
        //then
        Assertions.assertEquals(newPostContent,post.getContent().getContentText());
    }




}
