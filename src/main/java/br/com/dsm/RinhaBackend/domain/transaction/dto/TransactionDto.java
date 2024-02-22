package br.com.dsm.RinhaBackend.domain.transaction.dto;

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
public class TransactionDto {

  private Integer valor;
  private String tipo;
  private String descricao;
}
