package com.hvn.springsubredditbackend.repository;

import com.hvn.blogwithspringandangular.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
}
