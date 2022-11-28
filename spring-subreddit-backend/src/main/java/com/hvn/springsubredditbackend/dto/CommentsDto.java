package com.hvn.springsubredditbackend.dto;

import com.hvn.springsubredditbackend.model.Post;
import com.hvn.springsubredditbackend.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentsDto {
    private Long id;
    private Long postId;
    private String text;
    private Instant createdDate;
    private String userName;

}
