package io.faluche.cantum.repository;

import io.faluche.cantum.entity.TitreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitreRepository extends JpaRepository<TitreEntity, Long> {
    List<TitreEntity> findAllByNom(String nom);
}
