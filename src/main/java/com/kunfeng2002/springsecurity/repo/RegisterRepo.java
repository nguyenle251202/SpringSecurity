package com.kunfeng2002.springsecurity.repo;

import com.kunfeng2002.springsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepo extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
