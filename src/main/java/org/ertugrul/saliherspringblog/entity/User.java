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
@Table(name = "tbluser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    String email;
    String password;

    @OneToMany(mappedBy = "user")
    List<Post> posts;
    @OneToMany(mappedBy = "user")
    List<Comment> comments;

    @Embedded
    BaseEntity baseEntity;

}
