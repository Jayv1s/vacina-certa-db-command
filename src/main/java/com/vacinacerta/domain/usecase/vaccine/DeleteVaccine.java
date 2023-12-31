package com.vacinacerta.domain.usecase.vaccine;

import com.vacinacerta.domain.repository.IVaccineRepository;
import com.vacinacerta.domain.usecase.IUseCase;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Qualifier("DeleteVaccine")
public class DeleteVaccine implements IUseCase<String, Void> {

    @Autowired
    private final IVaccineRepository vaccineRepository;

    @Override
    public Void execute(String vaccineId) {
        vaccineRepository.deleteById(vaccineId);
        return null;
    }
}
