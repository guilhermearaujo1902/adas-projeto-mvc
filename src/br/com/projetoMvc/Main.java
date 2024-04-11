package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		
		ProdutoController controller = new ProdutoController();
		int opcao = 0;
		
		do {
			String menu = "*** Menu de opções ***"
					.concat("\n[1] Listar todos")
					.concat("\n[2] Listar por ID")
					.concat("\n[3] Cadastrar")
					.concat("\n[4] Alterar")
					.concat("\n[5] Excluir")
					.concat("\n[0] Sair");
			
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (opcao) {
			
			case 1: // Listar todos
				List<Produto> lista = new ArrayList<Produto>();
				lista = controller.listarTodos();
				
				if (lista.size() > 0) {
					
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
					
				} else {
					JOptionPane.showMessageDialog(null, "Não existem produtos cadastrados!");
				}
				break;
				
			case 2:
				int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID a desejado"));
				Produto produtoEncontrado = controller.listarPorId(id);
				
				if (produtoEncontrado != null) {
					JOptionPane.showMessageDialog(null, "Produto encontrado: " + produtoEncontrado.getDescricao());
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para o ID " + id);
				}
				
				break;
				
			case 3: // Cadastrar
				Produto novoProduto = new Produto();
				novoProduto.setDescricao(JOptionPane.showInputDialog("Descrição do produto"));
				
				controller.cadastrar(novoProduto);
				break;
				
			case 4:
				JOptionPane.showMessageDialog(null, "Alterar");
				break;
				
			case 5: //Excluir 
				int idExclusao = Integer.parseInt(JOptionPane.showInputDialog("Qual ID do produto a ser excluído?"));
				if (controller.excluir(idExclusao)) {
					JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto com o ID " + idExclusao);
				}
				break;
				
			case 0:
				JOptionPane.showMessageDialog(null, "Saindo do sistema...");
				break;
				
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida pra o código " + opcao);
			}
		} while (opcao != 0);
		

	}

}
