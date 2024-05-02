package org.ertugrul.saliherspringblog.repository;

import org.ertugrul.saliherspringblog.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
