package com.hvn.springsubredditbackend.service;

import com.hvn.springsubredditbackend.config.exceptions.PostNotFoundException;
import com.hvn.springsubredditbackend.config.exceptions.SubredditNotFoundException;
import com.hvn.springsubredditbackend.dto.PostRequest;
import com.hvn.springsubredditbackend.dto.PostResponse;
import com.hvn.springsubredditbackend.mapper.PostMapper;
import com.hvn.springsubredditbackend.model.Post;
import com.hvn.springsubredditbackend.model.Subreddit;
import com.hvn.springsubredditbackend.model.User;
import com.hvn.springsubredditbackend.repository.PostRepository;
import com.hvn.springsubredditbackend.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class PostService {

    private final SubredditRepository subredditRepository;
    private final AuthService authService;
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @Transactional
    public Post saveOrUpdate(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new SubredditNotFoundException(postRequest.getSubredditName()));
        User currentUser = authService.getCurrentUser();
        return postRepository.save(postMapper.mapToEntity(postRequest, subreddit,currentUser));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostByCondition(PostRequest postRequest) {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
