package org.fastcampus.post.repository.entity.like;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.common.repository.entity.TimeBaseEntity;
import org.fastcampus.post.domain.Post;
import org.fastcampus.post.domain.comment.Comment;
import org.fastcampus.user.domain.User;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "community_like")
public class LikeEntity extends TimeBaseEntity {

    @EmbeddedId
    private LikeEntityId id;

    public LikeEntity(Post post, User likeedUser) {
        this.id = new LikeEntityId(post.getId(), likeedUser.getId(),LikeTarget.POST.name());
    }

    public LikeEntity(Comment comment, User likeedUser) {
        this.id = new LikeEntityId(comment.getId(), likeedUser.getId(),LikeTarget.COMMENT.name());
    }
}
