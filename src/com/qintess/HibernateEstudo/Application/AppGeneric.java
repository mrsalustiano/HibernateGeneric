package com.qintess.HibernateEstudo.Application;

import com.qintess.HibernateEstudo.DAO.GenericDAO;
import com.qintess.HibernateEstudo.Model.Produto;

public class AppGeneric {

	public static void main(String[] args) {
	
		Produto prod1 = new Produto();
		Produto prod2 = new Produto();

		
		GenericDAO<Produto> dao = new GenericDAO<Produto>();
		
		prod1.setNome("Carro");
		prod1.setValor(5000.0);
		
		dao.salvar(prod1);

		prod2.setNome("Bicicleta");
		prod2.setValor(1000.0);
		
		dao.salvar(prod2);
		
		
	//	System.out.println(prod.toString());
		
		
		for (Produto produto: dao.listaTodos(Produto.class)) {
			System.out.println(produto.toString());
		}


	}

}
