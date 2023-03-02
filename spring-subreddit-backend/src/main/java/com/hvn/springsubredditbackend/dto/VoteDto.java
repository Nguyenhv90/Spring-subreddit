package com.hvn.springsubredditbackend.dto;

import com.hvn.springsubredditbackend.model.VoteType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
    private VoteType voteType;
    private Long postId;
}
