package br.edu.iesp.banco;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import br.edu.iesp.banco.DAONews.DAONews;
import br.edu.iesp.entity.News;

public class testconexao {

	public static void main(String[] args) {

		DAONews daoNews = new DAONews();
		News news = new News();
		news.setNoticia("Aqui contem uma nova noticia ");

		news.setResumo("Aqui contem um novo resumo ");

		
		
		ArrayList<News> listNews = daoNews.listarNews();		
		for (News news2 : listNews) {
			news2.mostarNes();
		}
		
		for (News news2 : listNews) {
			if (news2.getId() == 1) {
				daoNews.alterarNews(news);
				System.out.println("alterado");
			}
		}

		for (News news2 : listNews) {
			news2.mostarNes();
		}

		Calendar cal = Calendar.getInstance();
		java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
		System.out.println(timestamp);
	}
}