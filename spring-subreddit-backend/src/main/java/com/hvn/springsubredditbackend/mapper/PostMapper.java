package com.hvn.springsubredditbackend.mapper;

import com.hvn.blogwithspringandangular.dto.PostRequest;
import com.hvn.blogwithspringandangular.dto.PostResponse;
import com.hvn.blogwithspringandangular.model.Post;
import com.hvn.blogwithspringandangular.model.Subreddit;
import com.hvn.blogwithspringandangular.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    Post MapToEntity(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}
