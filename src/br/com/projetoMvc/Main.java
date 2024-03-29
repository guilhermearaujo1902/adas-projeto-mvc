package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		ProdutoController controller = new ProdutoController();
		
		List<Produto> lista = new ArrayList<Produto>();
		lista = controller.listarTodos();
		
		System.out.println("- Lista de produtos -");
		for (Produto produto : lista) {
			System.out.println(produto.getDescricao());
		}

	}

}
