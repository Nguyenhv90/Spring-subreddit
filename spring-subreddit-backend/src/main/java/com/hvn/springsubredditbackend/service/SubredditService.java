package com.hvn.springsubredditbackend.service;

import com.hvn.blogwithspringandangular.config.exceptions.SpringRedditException;
import com.hvn.blogwithspringandangular.dto.SubredditDto;
import com.hvn.blogwithspringandangular.mapper.SubredditMapper;
import com.hvn.blogwithspringandangular.model.Subreddit;
import com.hvn.blogwithspringandangular.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubredditService {

    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto createSubreddit(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapToEntity(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll().stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(Collectors.toList());
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No Subreddit found"));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
}
