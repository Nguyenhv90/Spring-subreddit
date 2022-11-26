package com.hvn.springsubredditbackend.service;

import com.hvn.blogwithspringandangular.dto.PostRequest;
import com.hvn.blogwithspringandangular.dto.PostResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    @Transactional
    public void saveOrUpdate(PostRequest postRequest) {
    }

    public PostResponse getPost(Long id) {
        return null;
    }

    public List<PostResponse> getPostByCondition(PostRequest postRequest) {
        return null;
    }
}
