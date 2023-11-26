package com.vacinacerta.domain.repository;

import com.vacinacerta.domain.entities.db.UsersVaccines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsersVaccinesRepository extends JpaRepository<UsersVaccines, String> {
}
