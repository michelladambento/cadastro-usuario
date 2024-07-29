package com.michell_bento.cadastrousuario.api.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {

    private String name;

    private String email;

    private String document;

    private AddressRequestDTO address;

}
