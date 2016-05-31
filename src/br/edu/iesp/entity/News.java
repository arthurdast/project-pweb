package br.edu.iesp.entity;

import java.sql.Timestamp;

public class News {
	//classe responsavel pelas noticias
	private int id;
	private String categoria;
	private String manchete;
	private String resumo;
	private String noticia;
	private Timestamp data;
	
	

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getNoticia() {
		return noticia;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void mostarNews(){
		
		System.out.println(id );
		System.out.println( manchete );
		System.out.println( resumo );
		System.out.println( noticia );
		

	}

	public String getManchete() {
		return manchete;
	}

	public void setManchete(String manchete) {
		this.manchete = manchete;
	}
	
	
}
