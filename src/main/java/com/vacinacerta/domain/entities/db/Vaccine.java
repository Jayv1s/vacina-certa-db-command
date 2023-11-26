package com.vacinacerta.domain.entities.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Vacinas")
public class Vaccine {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length=32)
    public String id;

    @Column(name = "nome_popular", length=100)
    public String popularName;

    @Column(name = "nome_completo", length=150)
    public String fullName;

    @Column(name = "fabricante", length=50)
    public String manufacturer;

    @Column(name = "idade_recomendada", length=3)
    public Integer age;

    @Column(name = "ano_recomendado", length=4)
    public Integer year;

    @Column(name = "criado_em")
    public LocalDateTime createdAt;

    @Column(name = "atualizado_em", length=4)
    public LocalDateTime updatedAt;

    @Column(name = "dose")
    public String dosage;

    @Column(name = "descricao")
    public String description;

    @Column(name = "obrigatorio")
    public Boolean required;

}