package com.project.plateposting.api.content.entity;

import com.project.plateposting.api.article.entity.Article;
import com.project.plateposting.api.article.entity.ArticleContent;
import com.project.plateposting.api.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "content")
    private List<ArticleContent> articleContents = new ArrayList<>();

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
