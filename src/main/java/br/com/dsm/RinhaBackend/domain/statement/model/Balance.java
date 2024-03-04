package br.com.dsm.RinhaBackend.domain.statement.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "total", "data_extrato", "limite" })
public class Balance {
    @JsonProperty("total")
    public Integer total;
    @JsonProperty("data_extrato")
    public LocalDateTime dataExtrato;
    @JsonProperty("limite")
    public Integer limite;

}
