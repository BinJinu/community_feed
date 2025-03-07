package org.fastcampus.post.doamin.content;

import org.fastcampus.post.domain.content.PostContent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PostContentTest {

    @Test
    void givenContentLengthIsOk_whenCreated_thenReturnTextContent() {
        //given
        String text = "this is a test";


        //when
        PostContent content = new PostContent(text);

        //then
        Assertions.assertEquals(text, content.getContentText());
    }

    @ParameterizedTest
    @ValueSource(strings = {"뷁, 닭, 긁, 삵, 숧"})
    void givenContentLengthIsOk_whenCreated_thenReturnPostContent(String koreanWord) {
        //given
        String content = koreanWord.repeat(501);

        //when
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

    @Test
    void givenContentLengthIsOk_whenCreated_thenReturnPostContent() {
        //given
        String content = "a".repeat(4);

        //when, then
        Assertions.assertThrows(IllegalArgumentException.class, () -> new PostContent(content));
    }

}
