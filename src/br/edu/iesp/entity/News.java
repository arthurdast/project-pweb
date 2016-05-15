package br.edu.iesp.entity;

public class News {
	//classe responsavel pelas noticias
	private int id;
	private String manchete;
	private String resumo;
	private String noticia;
	

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getNoticia() {
		return noticia;
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
