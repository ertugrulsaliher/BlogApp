package org.ertugrul.saliherspringblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tblpost-category",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    List<Category> category;


    @OneToMany(mappedBy = "post")
    List<Comment> comment;


    @Embedded
    BaseEntity baseEntity;





}
