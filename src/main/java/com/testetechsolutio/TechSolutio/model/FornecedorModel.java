package com.testetechsolutio.TechSolutio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_fornecedor")

public class FornecedorModel {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idFornecedor;

		@NotBlank
		private String tipoServico;

		@OneToMany(mappedBy = "idfornecedor", cascade = javax.persistence.CascadeType.ALL)
		@JsonIgnoreProperties
			
		public Long getIdFornecedor() {
			return idFornecedor;
		}

		public void setIdFornecedor(Long idFornecedor) {
			this.idFornecedor = idFornecedor;
		}

		public String getTipoServico() {
			return tipoServico;
		}

		public void setTipoServico(String tipoServico) {
			this.tipoServico = tipoServico;
		}

						
	}

