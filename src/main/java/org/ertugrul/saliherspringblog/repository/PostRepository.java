package org.ertugrul.saliherspringblog.repository;

import org.ertugrul.saliherspringblog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser_Id(Long userId);



    List<Post> findAllByCategory_Id(Long id);

    List<Post> findAllByContentContainsIgnoreCase(String aramaKelimesi);




}
