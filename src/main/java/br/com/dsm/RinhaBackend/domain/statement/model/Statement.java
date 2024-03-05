package br.com.dsm.RinhaBackend.domain.statement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "saldo", "ultimas_transacoes" })
public class Statement {
  @JsonProperty("saldo")
  public Balance saldo;
  @JsonProperty("ultimas_transacoes")
  public List<Transaction> ultimasTransacoes;

}
