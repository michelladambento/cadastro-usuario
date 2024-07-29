package com.michell_bento.cadastrousuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable = false)
    private String name;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="documento", nullable = false)
    private String document;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="endereco_id", referencedColumnName = "id")
    private AddressEntity address;


}
