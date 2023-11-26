package com.vacinacerta.domain.entities.db;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario_acesso")
public class UserAccess {
    @Id
    private String login;
    @Column(name = "senha")
    private String password;
    @Column(name = "acessos")
    private String roles;
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private User user;
}
