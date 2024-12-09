package com.project.plateposting.api.category.repository;

import com.project.plateposting.api.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.category.id = :parentId")
    Optional<Category> findByParentId(Long parentId);

}
