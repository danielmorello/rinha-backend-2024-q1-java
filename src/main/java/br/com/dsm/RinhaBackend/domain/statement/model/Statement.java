package br.com.dsm.RinhaBackend.domain.statement.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "saldo", "ultimas_transacoes" })
public class Statement {
  @JsonProperty("saldo")
  public Balance saldo;
  @JsonProperty("ultimas_transacoes")
  public List<LastTransactions> ultimasTransacoes;

}
