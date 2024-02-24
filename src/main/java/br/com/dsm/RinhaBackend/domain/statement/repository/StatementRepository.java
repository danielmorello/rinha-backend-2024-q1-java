package br.com.dsm.RinhaBackend.domain.statement.repository;

import br.com.dsm.RinhaBackend.domain.statement.model.Statement;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// TODO: verificar a adaptação para a classe de extrato
public interface StatementRepository extends JpaRepository<Statement, Id> {}
