package com.vacinacerta.domain.repository;

import com.entities.db.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserAccessRepository extends JpaRepository<UserAccess, String> {
}
