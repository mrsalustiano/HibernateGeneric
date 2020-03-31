package com.qintess.HibernateEstudo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Venda implements InterfaceModel  {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "venda")
    private List<ItemVenda> itens = new ArrayList<ItemVenda>();

    private double total;

    @Override
	public String toString() {
		return "Venda [id=" + id + ", itens=" + itens + ", total=" + total + "]";
	}

    
	public Venda() {
		
	}


	public Venda(List<ItemVenda> itens, double total) {

		this.itens = itens;
		this.total = total;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

