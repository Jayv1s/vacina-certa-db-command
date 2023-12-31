package com.vacinacerta.domain.repository;

import com.entities.db.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVaccineRepository extends JpaRepository<Vaccine, String> {
}
