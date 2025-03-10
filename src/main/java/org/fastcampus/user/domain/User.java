package org.fastcampus.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.fastcampus.common.domain.PositiveIntegerCounter;

import java.util.Objects;

@Getter
@Builder
@AllArgsConstructor
public class User {

    private Long id;
    private  UserInfo info;
    private  PositiveIntegerCounter followingCount;
    private PositiveIntegerCounter followerCounter;


    public User(Long id, UserInfo userInfo) {
        if (userInfo == null){
            throw new IllegalArgumentException();
        }

        this.id = id;
        this.info = userInfo;
        this.followingCount = new PositiveIntegerCounter();
        this.followerCounter = new PositiveIntegerCounter();
    }

    public void follow(User targetUser){
        if (targetUser.equals(this)){
            throw  new IllegalArgumentException();
        }

        followingCount.increase();
        targetUser.increaseFollowerCount();
    }

    public void unfollow(User targetUser){
        if (this.equals(targetUser)){
            throw  new IllegalArgumentException();
        }
        followingCount.decrease();
        targetUser.decreaseFollowerCount();
    }

    private void increaseFollowerCount() {
        followerCounter.increase();
    }

    private void decreaseFollowerCount() {
        followerCounter.decrease();
    }


    public int followerCount() {
        return followerCounter.getCount();
    }
    public int followingCount() {
        return followingCount.getCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(info, user.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, info);
    }

    public String getProfileImage() {
        return info.getProfileImageUrl();
    }
    public String getName() {
        return info.getName();
    }

}
