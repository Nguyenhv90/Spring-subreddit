package com.hvn.springsubredditbackend.repository;

import com.hvn.springsubredditbackend.model.Post;
import com.hvn.springsubredditbackend.model.User;
import com.hvn.springsubredditbackend.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
