package br.com.witzler.clientes.domain.entity;

import java.time.LocalDate;
import javax.persistence.*;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table( name="web_bandeiras", schema="pc" )
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Bandeiras {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_bandeira")
	private Integer id_bandeira;
	
	@Column(name="tipo_bandeira")
	private Integer tipo_bandeira;

	@Column(name="data_inicio")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate data_inicio;
	
		
}
