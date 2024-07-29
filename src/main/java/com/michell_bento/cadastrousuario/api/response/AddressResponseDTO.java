package com.michell_bento.cadastrousuario.api.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressResponseDTO {

    private Long id;

    private String street;

    private Long number;

    private String neighborhood;

    private String complement;

    private String city;

    private String cep;

}
