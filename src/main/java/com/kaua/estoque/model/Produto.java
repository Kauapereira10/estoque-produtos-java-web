package com.kaua.estoque.model;

import java.time.LocalDateTime;

public class Produto {
	private int id;
	private String nome;
	private String descricao;
	private double preco;
	private int quantidade;
	private LocalDateTime dataCadastro;
	private boolean ativo;
	
	
	public Produto() {}	
	
	public Produto(String nome, String descricao, double preco, int quantidade) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco >= 0 ? preco : 0;
		this.quantidade = quantidade >= 0 ? quantidade : 0;
		this.dataCadastro = LocalDateTime.now();
		this.ativo = true;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco >= 0 ? preco : 0;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade >= 0 ? quantidade : 0;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
}
