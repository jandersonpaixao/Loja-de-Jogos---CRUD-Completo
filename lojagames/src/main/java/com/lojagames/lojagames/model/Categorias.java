package com.lojagames.lojagames.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")
public class Categorias {
	
	@Id
	private Long id;
	
	@Size(max = 255)
	private String jogoTerror;
	
	@Size(max = 255)
	private String jogoAventuras;
	
	@Size(max = 255)
	private String jogoCorrida;
	
	@Size(max = 255)
	private String jogoLuta;
	
	@Size(max = 255)
	private String jogoEsportes;
	
	@Size(max = 255)
	private String eletronicos;
	
	@Size(max = 255)
	private String descricao;
	
	@OneToMany(mappedBy = "categorias", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categorias")
	private List<Produtos> produtos;
	
	

	public String getDescrição() {
		return descricao;
	}

	public void setDescrição(String descrição) {
		this.descricao = descrição;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public String getJogoTerror() {
		return jogoTerror;
	}

	public void setJogoTerror(String jogoTerror) {
		this.jogoTerror = jogoTerror;
	}

	public String getJogoAventuras() {
		return jogoAventuras;
	}

	public void setJogoAventuras(String jogoAventuras) {
		this.jogoAventuras = jogoAventuras;
	}

	public String getJogoCorrida() {
		return jogoCorrida;
	}

	public void setJogoCorrida(String jogoCorrida) {
		this.jogoCorrida = jogoCorrida;
	}

	public String getJogoLuta() {
		return jogoLuta;
	}

	public void setJogoLuta(String jogoLuta) {
		this.jogoLuta = jogoLuta;
	}

	public String getJogoEsportes() {
		return jogoEsportes;
	}

	public void setJogoEsportes(String jogoEsportes) {
		this.jogoEsportes = jogoEsportes;
	}

	public String getEletronicos() {
		return eletronicos;
	}

	public void setEletronicos(String eletronicos) {
		this.eletronicos = eletronicos;
	}
	
	
}
