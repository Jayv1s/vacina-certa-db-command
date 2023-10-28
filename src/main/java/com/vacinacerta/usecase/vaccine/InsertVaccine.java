package com.vacinacerta.usecase.vaccine;

import com.entities.db.Vaccine;
import com.vacinacerta.repository.IVaccineRepository;
import com.vacinacerta.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Qualifier("InsertVaccine")
public class InsertVaccine implements IUseCase<Vaccine, String> {

    @Autowired
    private final IVaccineRepository vaccineRepository;

    @Override
    public String execute(Vaccine vaccine) {
        vaccine.setCreatedAt(LocalDateTime.now());
        vaccine.setUpdatedAt(LocalDateTime.now());
        Vaccine res = vaccineRepository.save(vaccine);
        return res.getId();
    }
}
