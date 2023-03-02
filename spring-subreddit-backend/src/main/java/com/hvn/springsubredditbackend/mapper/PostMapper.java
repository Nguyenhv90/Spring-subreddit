package com.hvn.springsubredditbackend.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import com.hvn.springsubredditbackend.dto.PostRequest;
import com.hvn.springsubredditbackend.dto.PostResponse;
import com.hvn.springsubredditbackend.model.Post;
import com.hvn.springsubredditbackend.model.Subreddit;
import com.hvn.springsubredditbackend.model.User;
import com.hvn.springsubredditbackend.repository.CommentRepository;
import com.hvn.springsubredditbackend.repository.VoteRepository;
import com.hvn.springsubredditbackend.service.AuthService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private AuthService authService;

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "subreddit", source = "subreddit")
    @Mapping(target = "voteCount", constant = "0")
    public abstract Post mapToEntity(PostRequest postRequest, Subreddit subreddit, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "subredditName", source = "subreddit.name")
    @Mapping(target = "userName", source = "user.username")
    @Mapping(target = "commentCount", expression = "java(commentCount(post))")
    @Mapping(target = "duration", expression = "java(getDuration(post))")
    public abstract PostResponse mapToDto(Post post);


    Integer commentCount(Post post) {
        return commentRepository.findByPost(post).size();
    }

    String getDuration(Post post) {
        return TimeAgo.using(post.getCreatedDate().toEpochMilli());
    }
}
