package com.authenticator.authenticator.repositories;

import com.authenticator.authenticator.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
}
