package org.fastcampus.user.application.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.common.repository.entity.TimeBaseEntity;
import org.fastcampus.post.repository.entity.post.PostEntity;
import org.fastcampus.user.domain.User;
import org.fastcampus.user.domain.UserInfo;

import java.util.List;

@Entity
@Table(name = "community_user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserEntity extends TimeBaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String profileImage;
    private Integer followerCount;
    private Integer followingCount;

    public UserEntity(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.followerCount = user.followerCount();
        this.followingCount = user.followingCount();
    }


    public User toUser() {
        return User.builder()
                .id(id)
                .info(new UserInfo(name, profileImage))
                .followerCounter(new PositiveIntegerCounter(followerCount))
                .followingCount(new PositiveIntegerCounter(followingCount))
                .build();
    }
}
