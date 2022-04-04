package com.authenticator.authenticator.repositories;

import com.authenticator.authenticator.models.auth.ERole;
import com.authenticator.authenticator.models.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);


}
