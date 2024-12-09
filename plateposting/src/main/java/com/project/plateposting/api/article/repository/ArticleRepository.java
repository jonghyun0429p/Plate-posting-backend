package com.project.plateposting.api.article.repository;

import com.project.plateposting.api.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Optional<Article> findByCategory_id(Long category_id);

    Optional<Article> findByMember_Id(Long member_Id);

    Optional<Article> findByTitle(String title);

}
