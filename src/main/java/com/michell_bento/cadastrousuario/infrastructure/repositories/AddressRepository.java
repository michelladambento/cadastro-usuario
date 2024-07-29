package com.michell_bento.cadastrousuario.infrastructure.repositories;

import com.michell_bento.cadastrousuario.infrastructure.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
