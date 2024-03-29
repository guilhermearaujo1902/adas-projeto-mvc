package br.com.projetoMvc.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projetoMvc.DAO.GenericDAO;
import br.com.projetoMvc.DAO.ProdutoDAOImpl;
import br.com.projetoMvc.model.Produto;

public class ProdutoController {
	
	public List<Produto> listarTodos() {
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			
			for (Object object : dao.listarTodos()) {
				listaProdutos.add( (Produto) object );
			}
			
		} catch (Exception e) {
			System.out.println("Erro na Controller ao listar Produto.");
			e.printStackTrace();
		}
		
		return listaProdutos;
	}

}
