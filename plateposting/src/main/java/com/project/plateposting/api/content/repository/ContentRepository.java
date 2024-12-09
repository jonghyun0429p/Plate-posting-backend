package com.project.plateposting.api.content.repository;

import com.project.plateposting.api.content.entity.Content;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContentRepository {
    Optional<Content> findById(long id);
    List<Content> findByTitleContaining(String title);
    Optional<Content> findByArticleId(long articleId);
    Optional<Content> findByAuthorId(long authorId);
}
