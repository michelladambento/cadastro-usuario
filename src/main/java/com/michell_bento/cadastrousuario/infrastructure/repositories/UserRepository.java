package com.michell_bento.cadastrousuario.infrastructure.repositories;

import com.michell_bento.cadastrousuario.infrastructure.entities.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);


}
