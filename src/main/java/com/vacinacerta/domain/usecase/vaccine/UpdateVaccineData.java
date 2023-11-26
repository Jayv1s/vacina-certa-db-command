package com.vacinacerta.domain.usecase.vaccine;

import com.vacinacerta.domain.entities.db.Vaccine;
import com.vacinacerta.domain.repository.IVaccineRepository;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Qualifier("UpdateVaccineData")
public class UpdateVaccineData implements IUseCase<Vaccine, Vaccine> {

    @Autowired
    private final IVaccineRepository vaccineRepository;

    @Override
    public Vaccine execute(Vaccine vaccine) {
        vaccine.setUpdatedAt(LocalDateTime.now());
        return vaccineRepository.save(vaccine);
    }
}
