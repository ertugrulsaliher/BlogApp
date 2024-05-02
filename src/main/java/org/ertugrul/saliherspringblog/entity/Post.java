package org.ertugrul.saliherspringblog.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tblpost")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String content;

    @ManyToOne
    User user;

    @ManyToMany (mappedBy = "posts")
    List<Category> categories;

    @OneToMany(mappedBy = "post")
    List<Comment> comments;


    @Embedded
    BaseEntity baseEntity;





}
