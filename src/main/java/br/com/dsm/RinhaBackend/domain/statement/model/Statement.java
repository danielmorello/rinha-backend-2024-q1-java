package br.com.dsm.RinhaBackend.domain.statement.model;

import java.time.LocalDateTime;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
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
  private Integer valor;
  private String tipo;
  private String descricao;
  @ManyToOne(fetch = FetchType.LAZY)
  private User cliente;
  private LocalDateTime realizada_em;
}
