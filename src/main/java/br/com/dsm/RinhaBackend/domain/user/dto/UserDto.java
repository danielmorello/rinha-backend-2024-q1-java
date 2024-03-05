package br.com.dsm.RinhaBackend.domain.user.dto;

import java.util.List;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
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
public class UserDto {

  private Integer limite;
  private Integer saldo;
  private List<Transaction> transacoes;
}
