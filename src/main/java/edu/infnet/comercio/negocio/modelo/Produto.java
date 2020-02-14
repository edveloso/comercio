package edu.infnet.comercio.negocio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private Double preco;
	
	private String foto;
	
	//ctrl espaco enter (contrutor vazio)
	//ctrl 3 gcuf e ggas
	public Produto() {
	}
	
	
	public Produto(String nome, String descricao, Double preco, String foto) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.foto = foto;
	}
	

	public Produto(Integer id, String nome, String descricao, Double preco, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.foto = foto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	

}
