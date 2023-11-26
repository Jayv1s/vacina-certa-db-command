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
@Table(name = "Usuarios")
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(length=32)
    private String id;

    @Column(name = "primeiro_nome", length = 50)
    private String firstName;

    @Column(name = "ultimo_nome", length = 50)
    private String lastName;

    @Column(name = "data_nascimento", length = 10)
    private LocalDateTime dateOfBirth;

    @Column(name = "documento", length = 30)
    private String document;

    @Column(name = "tipo_documento")
    private String documentType;

    @Column(name = "criado_em", updatable=false)
    private LocalDateTime createdAt;

    @Column(name = "atualizado_em")
    private LocalDateTime updatedAt;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "nome_utilizado")
    private String nickname;
}
