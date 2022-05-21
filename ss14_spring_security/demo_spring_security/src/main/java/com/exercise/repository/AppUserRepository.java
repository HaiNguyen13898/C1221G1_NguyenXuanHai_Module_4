package com.exercise.repository;

import com.exercise.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
AppUser findByUserName(String userName);

}
