package com.qintess.HibernateEstudo.Application;

import java.util.ArrayList;
import java.util.List;

import com.qintess.HibernateEstudo.DAO.GenericDAO;
import com.qintess.HibernateEstudo.Model.ItemVenda;
import com.qintess.HibernateEstudo.Model.Produto;
import com.qintess.HibernateEstudo.Model.Venda;

public class AppGeneric {

	public static void main(String[] args) {
	
		Produto prod1 = new Produto();
		Produto prod2 = new Produto();
		Produto prod3 = new Produto();
		Produto prod4 = new Produto();

		
		GenericDAO<Produto> dao = new GenericDAO<Produto>();
		
		prod1.setNome("PS5");
		prod1.setValor(5000.0);
		dao.salvar(prod1);

		prod2.setNome("XIOMI MI9");
		prod2.setValor(1000.0);
		dao.salvar(prod2);

		prod3.setNome("IPHONE XS");
		prod3.setValor(1000.0);
		dao.salvar(prod3);
		
		prod4.setNome("GALAXY S20");
		prod4.setValor(6000.0);
		dao.salvar(prod4);
		
		
		List<ItemVenda> ItensDavendas = new ArrayList<ItemVenda>();
		
		
		Venda venda1 = new Venda();
		GenericDAO<Venda> daoVenda = new GenericDAO<Venda>();
		
		venda1.setItens(ItensDavendas);
		venda1.setTotal(0);
		
		daoVenda.salvar(venda1);

	
		ItemVenda item1 =  new ItemVenda();
		GenericDAO<ItemVenda> daoItem = new GenericDAO<ItemVenda>();	
		
		item1.setProduto(prod1);
		item1.setQtd(10);
		item1.setSubtotal(50000);
		item1.setVenda(venda1);
		
		daoItem.salvar(item1);

		
		
		for (Produto produto: dao.listaTodos(Produto.class)) {
			System.out.println(produto.toString());
		}

		
		
		  for (Venda vendas: daoVenda.listaTodos(Venda.class)) {
		  System.out.println(vendas.toString()); }
		 
	
		
		
		  for (ItemVenda ivenda: daoItem.listaTodos(ItemVenda.class)) {
		  System.out.println(ivenda.toString()); }
		 
	

	}

}
