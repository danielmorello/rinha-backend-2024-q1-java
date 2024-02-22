package br.com.dsm.RinhaBackend.domain.statement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StatementDto {
  // TODO: verificar a adaptação para a classe de extrato
  private Integer valor;
  private String tipo;
  private String descricao;
}
