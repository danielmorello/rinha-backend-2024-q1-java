package br.com.dsm.RinhaBackend.domain.user.model;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import br.com.dsm.RinhaBackend.domain.user.exception.UserInsufficientBalanceException;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "tb_user", schema = "public")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Integer id;

	private Integer limite;
	private Integer saldo;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonManagedReference
	@OrderBy("realizada_em DESC")
	private List<Transaction> transacoes = new ArrayList<>();

	public Integer updateBalance(Integer transactionValue, String transactionType) {
		if (transactionType.equals("c")) {
			this.saldo = this.saldo + transactionValue;
		} else if (transactionType.equals("d")) {
			if (this.saldo - transactionValue >= (this.limite * (-1))) {
				this.saldo = this.saldo - transactionValue;
			} else {
				throw new UserInsufficientBalanceException("Cliente tem limite insuficiente.");
			}
		}

		return this.saldo;
	}
}
