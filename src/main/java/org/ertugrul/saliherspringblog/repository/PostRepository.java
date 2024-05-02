package org.ertugrul.saliherspringblog.repository;

import org.ertugrul.saliherspringblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
