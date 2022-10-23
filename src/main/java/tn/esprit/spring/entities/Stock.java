package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table (name="Stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Stock implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idStock")
	private Long idStock;
	private String stockName;
	private Integer qte;
	private Integer minQte;
	private String description;
	@OneToMany(mappedBy = "stock")
	@JsonIgnore
	private Set<Product> products;

}
