package com.authenticator.authenticator.repositories;

import com.authenticator.authenticator.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
