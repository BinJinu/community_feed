package org.fastcampus.user.repository;

import org.fastcampus.user.application.interfases.UserRelationRepository;
import org.fastcampus.user.domain.User;

import java.util.HashSet;
import java.util.Set;

public class FakeUSerRelationRepository implements UserRelationRepository {
    private final Set<Relation> store = new HashSet<>();


    @Override
    public boolean isAlreadyFollow(User user, User targetUser) {
        return store.contains(new Relation(user.getId(), targetUser.getId()));
    }

    @Override
    public void save(User user, User targetUser) {
        store.add(new Relation(user.getId(), targetUser.getId()));

    }

    @Override
    public void delete(User user, User targetUser) {
        store.remove(new Relation(user.getId(), targetUser.getId()));
    }
}

record Relation(Long userId, Long targetUserid){}
