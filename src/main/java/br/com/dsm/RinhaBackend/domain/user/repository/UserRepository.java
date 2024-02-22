package br.com.dsm.RinhaBackend.domain.user.repository;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Id> {}
