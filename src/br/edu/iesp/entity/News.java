package br.edu.iesp.entity;

public class News {

	private int id;
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
	
	public void mostarNes(){
		
		System.out.println(id );
		System.out.println( resumo );
		System.out.println( noticia );

	}
	
}
