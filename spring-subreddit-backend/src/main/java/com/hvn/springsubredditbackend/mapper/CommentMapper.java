package com.hvn.springsubredditbackend.mapper;

import com.hvn.springsubredditbackend.dto.CommentsDto;
import com.hvn.springsubredditbackend.dto.PostRequest;
import com.hvn.springsubredditbackend.dto.PostResponse;
import com.hvn.springsubredditbackend.dto.SubredditDto;
import com.hvn.springsubredditbackend.model.Comment;
import com.hvn.springsubredditbackend.model.Post;
import com.hvn.springsubredditbackend.model.Subreddit;
import com.hvn.springsubredditbackend.model.User;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    Comment mapToEntity(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", source = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", source = "java(comment.getUser().getUsername)")
    CommentsDto mapToDto(Comment comment);
}
