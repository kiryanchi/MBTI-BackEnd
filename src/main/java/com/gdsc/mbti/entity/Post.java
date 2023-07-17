package com.gdsc.mbti.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mbti;

    private String nickname;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comment> comments;

    @Builder
    public Post(String mbti, String nickname, String content, List<Comment> comments) {
        this.mbti = mbti;
        this.nickname = nickname;
        this.content = content;
        this.comments = comments;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateNickname(String nickname) {
        this.nickname = nickname;
    }

    public void updateMbti(String mbti) {
        this.mbti = mbti;
    }
}