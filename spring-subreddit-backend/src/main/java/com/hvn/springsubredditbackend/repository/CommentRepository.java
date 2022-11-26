package com.hvn.springsubredditbackend.repository;

import com.hvn.blogwithspringandangular.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
