package org.fastcampus.post.application.dto;

import org.fastcampus.post.domain.comment.Comment;

public record CreateCommentRequestDto(Long postId, Long userId, String content) {
}
