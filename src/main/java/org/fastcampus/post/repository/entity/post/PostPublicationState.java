package org.fastcampus.post.repository.entity.post;

import jakarta.persistence.AttributeConverter;
import org.fastcampus.post.domain.content.PostPublication;

public class PostPublicationState implements AttributeConverter<PostPublication, String> {


    @Override
    public String convertToDatabaseColumn(PostPublication postPublication) {
        return postPublication.name();
    }

    @Override
    public PostPublication convertToEntityAttribute(String s) {
        return PostPublication.valueOf(s);
    }
}
