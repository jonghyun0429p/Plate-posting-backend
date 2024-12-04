package com.project.plateposting.article;

import com.project.plateposting.category.Category;
import com.project.plateposting.content.Content;
import com.project.plateposting.member.Member;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @NotNull
    private Category category;


    //Article과 Content가 다대다 인데, 어짜피 테이블이 하나 생기는 식으로 관리됨.
    //그렇다면 그냥 직접 1대n, n대1로 쪼개서 관리도 가능함.
    @NotNull
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "article_content",
                joinColumns = @JoinColumn(name = "id"),
                inverseJoinColumns = @JoinColumn(name = "content_id"))
    private List<Content> contents = new ArrayList<>();

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
