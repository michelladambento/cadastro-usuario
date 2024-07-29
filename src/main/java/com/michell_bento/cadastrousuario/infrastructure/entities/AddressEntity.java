package com.michell_bento.cadastrousuario.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="rua")
    private String street;

    @Column(name="numero")
    private Long number;

    @Column(name="bairro")
    private String neighborhood;

    @Column(name="complemento")
    private String complement;

    @Column(name="cidade")
    private String city;

    @Column(name="cep")
    private String cep;

}
