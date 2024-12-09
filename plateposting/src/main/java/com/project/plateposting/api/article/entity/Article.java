package com.project.plateposting.api.article.entity;

import com.project.plateposting.api.category.entity.Category;
import com.project.plateposting.api.content.entity.Content;
import com.project.plateposting.api.member.entity.Member;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "article")
    private List<ArticleContent> articleContents = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @NotNull
    private Member member;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name="like_count")
    @NotNull
    private int likeCount;

    @Column(name = "view_count")
    @NotNull
    private int viewCount;



}
