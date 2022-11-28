package com.hvn.springsubredditbackend.repository;


import com.hvn.springsubredditbackend.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
