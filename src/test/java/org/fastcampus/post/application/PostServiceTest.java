package org.fastcampus.post.application;

import org.fastcampus.fake.FakeObjectFactory;
import org.fastcampus.post.application.dto.CreatePostRequestDto;
import org.fastcampus.post.application.dto.LikeRequestDto;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.content.PostPublication;
import org.fastcampus.user.application.UserService;
import org.fastcampus.user.application.dto.CreateUserRequestDto;
import org.fastcampus.user.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PostServiceTest {

    private final UserService userService = FakeObjectFactory.getUserService();
    private final PostService postService = FakeObjectFactory.getPostService();


    private final User user = userService.createUser(new CreateUserRequestDto("user1",null));
    private final User otherUser = userService.createUser(new CreateUserRequestDto("user1",null));

    private final CreatePostRequestDto dto = new CreatePostRequestDto(user.getId(), "this is test", PostPublication.PUBLIC);

    @Test
    void givenPostRequestDto_whenCreate_thenReturnPost() {
        //when
        Post savePost = postService.createPost(dto);

        //then
        Post post = postService.getPost(savePost.getId());
        Assertions.assertEquals(savePost, post);
    }

    @Test
    void givenCreatePost_whenUpdate_thenReturnUpdatePost() {
        //given
        Post savedPost = postService.createPost(dto);

        //when
        Post updatedPost = postService.updatePost(savedPost.getId(), dto);

        //then
        Assertions.assertEquals(savedPost.getId(), updatedPost.getId());
        Assertions.assertEquals(savedPost.getAuthor(), updatedPost.getAuthor());
        Assertions.assertEquals(savedPost.getContent(), updatedPost.getContent());

    }

    @Test
    void givenCreatePost_whenLiked_thenReturnPostWithLike() {
        //given
        Post savedPost = postService.createPost(dto);

        //when
        LikeRequestDto likeRequestDto = new LikeRequestDto( savedPost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);

        //then
        Assertions.assertEquals(1,savedPost.getLikeCount());
    }

    @Test
    void  givenCreatePost_whenUnliked_thenReturnPostWithoutLike() {
        //given
        Post savedPost = postService.createPost(dto);

        //when
        LikeRequestDto likeRequestDto = new LikeRequestDto( savedPost.getId(), otherUser.getId());
        postService.likePost(likeRequestDto);
        postService.unlikePost(likeRequestDto);

        //then
        Assertions.assertEquals(0,savedPost.getLikeCount());
    }


}
