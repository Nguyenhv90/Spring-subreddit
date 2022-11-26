package com.hvn.springsubredditbackend.mapper;

import com.hvn.blogwithspringandangular.dto.SubredditDto;
import com.hvn.blogwithspringandangular.model.Post;
import com.hvn.blogwithspringandangular.model.Subreddit;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapToEntity(SubredditDto subredditDto);
}
