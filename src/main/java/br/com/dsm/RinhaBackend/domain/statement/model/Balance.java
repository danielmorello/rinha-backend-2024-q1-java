package br.com.dsm.RinhaBackend.domain.statement.model;

import java.time.Instant;

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
@JsonPropertyOrder({ "total", "data_extrato", "limite" })
public class Balance {
    @JsonProperty("total")
    public Integer total;
    @JsonProperty("data_extrato")
    public Instant dataExtrato;
    @JsonProperty("limite")
    public Integer limite;

}
