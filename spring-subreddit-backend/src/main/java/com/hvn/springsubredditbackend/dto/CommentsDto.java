package com.hvn.springsubredditbackend.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private Long id;
    private Long postId;
    private String text;
    private Instant createdDate;
    private String userName;

}
