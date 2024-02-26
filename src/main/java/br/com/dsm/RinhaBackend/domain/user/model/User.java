package br.com.dsm.RinhaBackend.domain.user.model;

import br.com.dsm.RinhaBackend.domain.transaction.model.Transaction;
import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "user", schema = "public")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Nonnull
	private Integer id;

	private Integer limite;
	private Integer saldo;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transacoes = new ArrayList<>();

	public Integer updateBalance(Integer transactionValue, String transactionType) {
		if (transactionType.equals("c")) {
			this.saldo = this.saldo + transactionValue;
		} else if (transactionType.equals("d")) {
			this.saldo = this.saldo - transactionValue;
		}

		return this.saldo;
	}
}
