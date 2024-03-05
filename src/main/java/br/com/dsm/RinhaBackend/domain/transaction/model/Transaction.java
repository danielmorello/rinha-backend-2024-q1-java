package br.com.dsm.RinhaBackend.domain.transaction.model;

import br.com.dsm.RinhaBackend.domain.user.model.User;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity
@Table(name = "tb_transaction", schema = "public")
public class Transaction {

	// TODO: Lembrar da limitação do tamanho da descrição
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	@JsonIgnore
	private Integer id;

	private Integer valor;
	private String tipo;
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private User cliente;

	private LocalDateTime realizada_em;

	public Boolean validatePositiveNumbers(Integer value) {
		return true;
	}
}
