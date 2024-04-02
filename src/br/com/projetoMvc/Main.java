package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		ProdutoController controller = new ProdutoController();
		
		Produto novoProduto = new Produto();
		novoProduto.setDescricao(JOptionPane.showInputDialog("Descrição do produto"));
		
		controller.cadastrar(novoProduto);
		
		
		List<Produto> lista = new ArrayList<Produto>();
		lista = controller.listarTodos();
		
		String mensagemLista = ""
				.concat("- Lista de produtos -")
				.concat("\n")
				.concat("Cód.   Descrição");
		
		for (Produto produto : lista) {
			mensagemLista = mensagemLista
					.concat("\n")
					.concat( String.valueOf(produto.getId()) )
					.concat("        ")
					.concat(produto.getDescricao());
		}
		
		JOptionPane.showMessageDialog(null, mensagemLista);
		
		

	}

}
