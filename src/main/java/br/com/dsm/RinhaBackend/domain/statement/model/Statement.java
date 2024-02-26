package br.com.dsm.RinhaBackend.domain.statement.model;

import java.time.LocalDateTime;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Statement {
  // TODO: verificar a adaptação para a classe de extrato
  private Integer valor;
  private String tipo;
  private String descricao;
  @ManyToOne(fetch = FetchType.LAZY)
  private User cliente;
  private LocalDateTime realizada_em;
}
