package com.hvn.springsubredditbackend.controller;

import com.hvn.springsubredditbackend.dto.PostRequest;
import com.hvn.springsubredditbackend.dto.PostResponse;
import com.hvn.springsubredditbackend.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostRequest postRequest) {
        postService.saveOrUpdate(postRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }
    @GetMapping("/search")
    public List<PostResponse> getAllPosts(@RequestBody PostRequest postRequest) {
        return postService.getPostByCondition(postRequest);
    }

}
