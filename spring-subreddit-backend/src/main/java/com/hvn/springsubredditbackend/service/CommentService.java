package com.hvn.springsubredditbackend.service;

import com.hvn.springsubredditbackend.config.exceptions.PostNotFoundException;
import com.hvn.springsubredditbackend.dto.CommentsDto;
import com.hvn.springsubredditbackend.mapper.CommentMapper;
import com.hvn.springsubredditbackend.model.Comment;
import com.hvn.springsubredditbackend.model.NotificationEmail;
import com.hvn.springsubredditbackend.model.Post;
import com.hvn.springsubredditbackend.model.User;
import com.hvn.springsubredditbackend.repository.CommentRepository;
import com.hvn.springsubredditbackend.repository.PostRepository;
import com.hvn.springsubredditbackend.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class CommentService {

    private static final String POST_URL = "";

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final MailService mailService;
    private final MailContentBuilder mailContentBuilder;

    public void saveOrUpdate(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException("Post not found with id - "+ commentsDto.getPostId()));
        Comment comment = commentMapper.mapToEntity(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);

        String message = mailContentBuilder.build(post.getUser().getUsername() + " posted a comment on yput post." + POST_URL);
        sendCommentNotification(message, post.getUser());
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + "commented on your post", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentForPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id - "+ postId));
        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public List<CommentsDto> getCommentsByUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException(userName));
        return commentRepository.findAllByUser(user)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(Collectors.toList());

    }
}
