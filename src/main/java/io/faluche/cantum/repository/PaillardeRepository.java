package io.faluche.cantum.repository;

import io.faluche.cantum.repository.domain.Paillarde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaillardeRepository  extends JpaRepository<Paillarde, Long> {
}
