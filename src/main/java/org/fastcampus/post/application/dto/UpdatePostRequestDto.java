package org.fastcampus.post.application.dto;

import org.fastcampus.post.domain.content.PostPublication;

public record UpdatePostRequestDto(Long postId, Long userId, String content, PostPublication state) {


}
