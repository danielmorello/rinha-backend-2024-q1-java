package br.com.dsm.RinhaBackend.domain.transaction.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Data
@Entity
@Table(name = "transaction", schema = "public")
public class Transaction {
  // TODO: Refazer os tipos e os nomes das funções para adaptar para as transações
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Nonnull
  private Integer id;

  private Integer limite;
  private Integer saldo;
}
