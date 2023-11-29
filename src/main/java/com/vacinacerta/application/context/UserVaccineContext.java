package com.vacinacerta.application.context;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class UserVaccineContext {
    String userId;
    List<String> vaccineIds;
    String vaccineId;
}
