package com.vacinacerta.domain.entities.mapper;

import com.vacinacerta.domain.entities.db.Vaccine;
import com.vacinacerta.domain.entities.dto.VaccineDTO;

public class VaccineMapper {
    public static VaccineDTO convertToVaccineDTO(Vaccine vaccine) {
        return VaccineDTO.builder()
                .age(vaccine.getAge())
                .year(vaccine.getYear())
                .createdAt(vaccine.getCreatedAt())
                .fullName(vaccine.getFullName())
                .id(vaccine.getId())
                .manufacturer(vaccine.getManufacturer())
                .popularName(vaccine.getPopularName())
                .updatedAt(vaccine.getUpdatedAt())
                .dosage(vaccine.getDosage())
                .description(vaccine.getDescription())
                .required(vaccine.getRequired())
                .build();
    }

    public static Vaccine convertToVaccineDB(VaccineDTO vaccineDTO) {
        return Vaccine.builder()
                .age(vaccineDTO.getAge())
                .year(vaccineDTO.getYear())
                .createdAt(vaccineDTO.getCreatedAt())
                .fullName(vaccineDTO.getFullName())
                .id(vaccineDTO.getId())
                .manufacturer(vaccineDTO.getManufacturer())
                .popularName(vaccineDTO.getPopularName())
                .updatedAt(vaccineDTO.getUpdatedAt())
                .dosage(vaccineDTO.getDosage())
                .description(vaccineDTO.getDescription())
                .required(vaccineDTO.getRequired())
                .build();
    }
}
