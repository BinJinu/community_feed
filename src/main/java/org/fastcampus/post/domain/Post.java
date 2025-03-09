package org.fastcampus.post.domain;

import org.fastcampus.common.domain.PositiveIntegerCounter;
import org.fastcampus.post.domain.content.Content;
import org.fastcampus.post.domain.content.PostContent;
import org.fastcampus.post.domain.content.PostPublication;
import org.fastcampus.user.domain.User;

public class Post {

    private final Long id;
    private final User author;
    private final Content content;
    private final PositiveIntegerCounter likeCount;
    private PostPublication state;

    public static Post createPost(Long id, User author, String content, PostPublication state) {
        return new Post(id,author,new PostContent(content), state);
    }

    public static Post createDefaultPost(Long id, User author, String content) {
        return new Post(id, author, new PostContent(content), PostPublication.PUBLIC);
    }

    public Post(Long id, User author, Content content) {
        this(id, author, content, PostPublication.PUBLIC);
    }


    public Post(Long id, User author, Content content, PostPublication state) {
        if(author == null){
            throw new IllegalArgumentException();
        }
        this.id = id;
         this.author = author;
        this.content = content;
        this.likeCount = new PositiveIntegerCounter();
        this.state = PostPublication.PUBLIC;
    }

    public void like(User user){
        if (this.author.equals(user)){
            throw new IllegalArgumentException();
        }
        likeCount.increase();
    }

    public void unlike(){
        this.likeCount.decrease();
    }
    public Long getId() {
        return id;
    }
    public User getAuthor() {
        return author;
    }
    public Content getContent() {
        return content;
    }
    public int getLikeCount() {
        return likeCount.getCount();
    }


    public void updatePost(User user, String updateContent,PostPublication state){
        if (!this.author.equals(user)){
            throw new IllegalArgumentException();
        }

        this.state = state;
        this.content.updateContent(updateContent);
    }
}
