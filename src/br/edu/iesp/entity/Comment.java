package br.edu.iesp.entity;

import java.sql.Timestamp;

public class Comment {
//classe responsavel pelos comentarios
	private int id;
	private String comentario;
	private String nome;
	private String email;
	private int fk_news;
	private Timestamp data;
	
	
	
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFk_news() {
		return fk_news;
	}
	public void setFk_news(int fk_news) {
		this.fk_news = fk_news;
	}
	
	
	
	
}
