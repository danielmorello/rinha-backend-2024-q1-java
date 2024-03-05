package br.com.dsm.RinhaBackend.domain.statement.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "valor", "tipo", "descricao", "realizada_em" })
public class LastTransactions {
    @JsonProperty("valor")
    public Long valor;
    @JsonProperty("tipo")
    public String tipo;
    @JsonProperty("descricao")
    public String descricao;
    @JsonProperty("realizada_em")
    public String realizadaEm;
}
