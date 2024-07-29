package com.michell_bento.cadastrousuario.api.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequestDTO {

    private String street;

    private Long number;

    private String neighborhood;

    private String complement;

    private String city;

    private String cep;

}
