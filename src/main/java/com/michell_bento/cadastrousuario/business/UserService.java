package com.michell_bento.cadastrousuario.business;

import com.michell_bento.cadastrousuario.api.converter.UserConverter;
import com.michell_bento.cadastrousuario.api.request.UserRequestDTO;
import com.michell_bento.cadastrousuario.api.response.UserResponseDTO;
import com.michell_bento.cadastrousuario.infrastructure.entities.UserEntity;
import com.michell_bento.cadastrousuario.infrastructure.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    public UserEntity saveUser(UserEntity user){

        return userRepository.saveAndFlush(user);

    }

    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO){
        try {
            UserEntity userEntity = saveUser(userConverter.toUserEntity(userRequestDTO));
            return userConverter.toUserResponseDTO(userEntity);
        }catch (Exception e){
            throw new RuntimeException("Error to save date from user");
        }
    }

    public UserResponseDTO findUserByEmail(String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        return userConverter.toUserResponseDTO(userEntity);
    }

    public void deleteUser(String email){
        userRepository.deleteByEmail(email);
    }

    public List<UserResponseDTO> findAllUser(){
        List<UserEntity> usersEntity = userRepository.findAll();
        return userConverter.toUserResponseDTO(usersEntity);
    }


}
