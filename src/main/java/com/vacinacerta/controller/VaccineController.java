package com.vacinacerta.controller;

import com.entities.db.Vaccine;
import com.vacinacerta.usecase.IUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/vaccine")
public class VaccineController {

    private final IUseCase<Vaccine, String> insertVaccine;
    private final IUseCase<Vaccine, Vaccine> updateVaccine;
    private final IUseCase<String, Void> deleteVaccine;

    @Autowired
    private VaccineController(
            @Qualifier("InsertVaccine")
            IUseCase<Vaccine, String> insertVaccine,
            @Qualifier("UpdateVaccineData")
            IUseCase<Vaccine, Vaccine> updateVaccine,
            @Qualifier("DeleteVaccine")
            IUseCase<String, Void> deleteVaccine
    ) {
        this.insertVaccine = insertVaccine;
        this.updateVaccine = updateVaccine;
        this.deleteVaccine = deleteVaccine;
    }

    @PostMapping("/")
    public ResponseEntity<String> insertVaccine(@RequestBody Vaccine vaccine) {
        var response = insertVaccine.execute(vaccine);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{vaccineId}")
    public ResponseEntity<Vaccine> updateVaccine(@RequestBody Vaccine vaccine, @PathVariable String vaccineId) {
        vaccine.setId(vaccineId);
        var response = updateVaccine.execute(vaccine);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{vaccineId}")
    public ResponseEntity<Vaccine> deleteVaccine(@PathVariable String vaccineId) {
        deleteVaccine.execute(vaccineId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
