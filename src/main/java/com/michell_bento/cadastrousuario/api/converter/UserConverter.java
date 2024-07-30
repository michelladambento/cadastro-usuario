package com.michell_bento.cadastrousuario.api.converter;

import com.michell_bento.cadastrousuario.api.request.AddressRequestDTO;
import com.michell_bento.cadastrousuario.api.request.UserRequestDTO;
import com.michell_bento.cadastrousuario.api.response.AddressResponseDTO;
import com.michell_bento.cadastrousuario.api.response.UserResponseDTO;
import com.michell_bento.cadastrousuario.infrastructure.entities.AddressEntity;
import com.michell_bento.cadastrousuario.infrastructure.entities.UserEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public UserEntity toUserEntity(UserRequestDTO userDTO){
        return UserEntity.builder()
                .name(userDTO.getName())
                .document(userDTO.getDocument())
                .email(userDTO.getEmail())
                .address(toAddressEntity(userDTO.getAddress()))
                .build();
    }



    public AddressEntity toAddressEntity(AddressRequestDTO addressRequestDTO){
        return AddressEntity.builder()
                .street(addressRequestDTO.getStreet())
                .neighborhood(addressRequestDTO.getNeighborhood())
                .cep(addressRequestDTO.getCep())
                .complement(addressRequestDTO.getComplement())
                .city(addressRequestDTO.getCity())
                .number(addressRequestDTO.getNumber())
                .build();
    }

    public UserResponseDTO toUserResponseDTO(UserEntity userEntity){
        return UserResponseDTO.builder()
                .id(userEntity.getId())
                .name(userEntity.getName())
                .document(userEntity.getDocument())
                .email(userEntity.getEmail())
                .address(toAddressResponseDTO(userEntity.getAddress()))
                .build();
    }

    public List<UserResponseDTO> toUserResponseDTO(List<UserEntity> usersEntities){
        List<UserResponseDTO> usersResponseDTO = new ArrayList<>();
        for (UserEntity userEntity : usersEntities){
            usersResponseDTO.add(toUserResponseDTO(userEntity));
        }
        return usersResponseDTO;
    }

    public AddressResponseDTO toAddressResponseDTO(AddressEntity addressEntity){
        return AddressResponseDTO.builder()
                .id(addressEntity.getId())
                .street(addressEntity.getStreet())
                .neighborhood(addressEntity.getNeighborhood())
                .cep(addressEntity.getCep())
                .complement(addressEntity.getComplement())
                .city(addressEntity.getCity())
                .number(addressEntity.getNumber())
                .build();
    }
}
