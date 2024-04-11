package br.com.projetoMvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
	
	public void cadastrar(Produto produto) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			if (dao.cadastrar(produto)) {
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Problemas ao cadastrar produto.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void alterar(Produto produto) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			
			if (validarId(produto.getId()) == false) {
				JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para o ID " + produto.getId());
				return;
			}
			
			if (dao.alterar(produto) == true) {
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Problemas ao alterar produto.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Produto listarPorId(int id) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			Produto produto = (Produto) dao.listarPorId(id);
			return produto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean excluir(int id) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			
			if (validarId(id) == false) {
				return false;
			}
			
			dao.excluir(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean validarId(int id) {
		try {
			GenericDAO dao = new ProdutoDAOImpl();
			
			Produto produto = (Produto) dao.listarPorId(id);
			
			if (produto == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
