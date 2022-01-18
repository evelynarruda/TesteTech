package com.testetechsolutio.TechSolutio.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "tb_produto")
	
	public class ProdutoModel {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idProduto;
		
		@NotBlank
		private String nomeProduto;
		
		@ManyToOne
		@JsonIgnoreProperties("id_fornecedor")
		private FornecedorModel idFornecedor;
		
		@NotNull
		private double valor;

		public Long getIdProduto() {
			return idProduto;
		}

		public void setIdProduto(Long idProduto) {
			this.idProduto = idProduto;
		}

		public String getNomeProduto() {
			return nomeProduto;
		}

		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}

		public FornecedorModel getFornecedor() {
			return idFornecedor;
		}

		public void setFornecedor(FornecedorModel fornecedor) {
			this.idFornecedor = fornecedor;
		}

		public double getValor() {
			return valor;
		}

		public void setValor(double d) {
			this.valor = d;
		}

		public Optional<ProdutoModel> map(Optional<ProdutoModel> object) {
			return object;
			
		}

		public static Object save(@Valid ProdutoModel novoproduto) {
			return null;
		}
		
		}
		
		
