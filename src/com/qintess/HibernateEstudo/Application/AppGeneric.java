package com.qintess.HibernateEstudo.Application;

import java.util.ArrayList;
import java.util.List;

import com.qintess.HibernateEstudo.DAO.GenericDAO;
import com.qintess.HibernateEstudo.Model.ItemVenda;
import com.qintess.HibernateEstudo.Model.Produto;
import com.qintess.HibernateEstudo.Model.Venda;

public class AppGeneric {

	private static double total = 0.0;


	public static void main(String[] args) {

		Produto prod1 = new Produto();
		Produto prod2 = new Produto();
		Produto prod3 = new Produto();
		Produto prod4 = new Produto();

		GenericDAO<Produto> dao = new GenericDAO<Produto>();

		prod1.setNome("PS5");
		prod1.setValor(4499.98);
		dao.salvar(prod1);

		prod2.setNome("XIOMI MI9");
		prod2.setValor(2050.45);
		dao.salvar(prod2);

		prod3.setNome("IPHONE XS");
		prod3.setValor(12890.56);
		dao.salvar(prod3);

		prod4.setNome("GALAXY S20");
		prod4.setValor(7199.99);
		dao.salvar(prod4);

		Venda venda1 = new Venda();
		GenericDAO<Venda> daoVenda = new GenericDAO<Venda>();

		venda1.setTotal(0);

		daoVenda.salvar(venda1);
		List<ItemVenda> ItensDavendas = new ArrayList<ItemVenda>();

		ItensDavendas.add(new ItemVenda(prod1, venda1, 1, 0));
		ItensDavendas.add(new ItemVenda(prod2, venda1, 10, 0));

		GenericDAO<ItemVenda> daoItem = new GenericDAO<ItemVenda>();
		ItemVenda item1 = new ItemVenda();
		ItemVenda item2 = new ItemVenda();
		ItemVenda item3 = new ItemVenda();
		ItemVenda item4 = new ItemVenda();

		// item 1
		item1.setProduto(prod1);
		item1.setSubtotal(0);
		item1.setQtd(12);
		item1.setVenda(venda1);
		daoItem.salvar(item1);

		total += item1.getSubtotal();
		venda1.setTotal(total);
		daoVenda.salvar(venda1);

		// item 2

		item2.setProduto(prod2);
		item2.setSubtotal(0);
		item2.setQtd(11);
		item2.setVenda(venda1);
		daoItem.salvar(item2);

		total += item2.getSubtotal();
		venda1.setTotal(total);
		daoVenda.salvar(venda1);

		// item 3
		item3.setProduto(prod3);
		item3.setSubtotal(0);
		item3.setQtd(32);
		item3.setVenda(venda1);
		daoItem.salvar(item3);

		total += item3.getSubtotal();
		venda1.setTotal(total);
		daoVenda.salvar(venda1);

		// item 4
		item4.setProduto(prod4);
		item4.setSubtotal(0);
		item4.setQtd(41);
		item4.setVenda(venda1);
		daoItem.salvar(item4);

		total += item4.getSubtotal();
		venda1.setTotal(total);
		daoVenda.salvar(venda1);

		System.out.println("=============================================");
		System.out.println("            LISTAGEM DE PRODUTOS            ");
		System.out.println("=============================================");
		for (Produto produto : dao.listaTodos(Produto.class)) {
			System.out.println(produto.toString());
		}
		System.out.println("=============================================");

		
		System.out.println("=============================================");
		System.out.println("              LISTAGEM DE VENDAS             ");
		System.out.println("=============================================");

		for (Venda vendas : daoVenda.listaTodos(Venda.class)) {
			System.out.println(vendas.toString());
		}
		System.out.println("=============================================");

		
		System.out.println("=============================================");
		System.out.println("         LISTAGEM DE ITENS DA VENDAS         ");
		System.out.println("=============================================");
		
		for (ItemVenda ivenda : daoItem.listaTodos(ItemVenda.class)) {
			System.out.println(ivenda.toString());
		}
		System.out.println("=============================================");

	}

}
