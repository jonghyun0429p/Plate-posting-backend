package com.project.plateposting.content;

import com.project.plateposting.article.Article;
import com.project.plateposting.member.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;

    @JoinColumn(name = "author_id")
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "text")
    @NotNull
    private String text;

    @Column(name = "created_at")
    @NotNull
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "like_count")
    @NotNull
    private int likeCount;
}
