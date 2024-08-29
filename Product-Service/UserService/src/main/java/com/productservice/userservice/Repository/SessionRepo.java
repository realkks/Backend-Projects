package com.productservice.userservice.Repository;

import com.productservice.userservice.Models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session, Long> {
    // Repository for session
    Session save(Session session);
}
