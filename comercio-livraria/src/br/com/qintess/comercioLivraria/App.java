package br.com.qintess.comercioLivraria;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.qintess.comercioLivraria.dao.Dao;
import br.com.qintess.comercioLivraria.model.Autor;
import br.com.qintess.comercioLivraria.model.Cliente;
import br.com.qintess.comercioLivraria.model.Genero;
import br.com.qintess.comercioLivraria.model.Livro;
import br.com.qintess.comercioLivraria.model.Venda;

public class App {

	public static void main(String[] args) {
		Dao dao = new Dao();
// Genero
		Genero genero = new Genero();
		genero.setDescricao("Apocalipse Zumbi");
		Genero genero2 = new Genero();
		genero2.setDescricao("Apocalipse Zumbi");
//		dao.insere(genero);
//		dao.insere(genero2);
		
// Autor 
		Autor autor = new Autor();
		autor.setNome("Ferraz Ferrari");
		autor.setEmail("ferraz@Gmail.com");
		Autor autor2 = new Autor();
		autor2.setNome("Carrit Ryan");
		autor2.setEmail("Carrit@Gmail.com");
//		dao.insere(autor);
//		dao.insere(autor2);
//		
//		Cliete
		Cliente cliente = new Cliente();
		cliente.setNome("Eduardo");
		cliente.setTelefone("(11) 963475189");
		Cliente cliente2 = new Cliente();
		cliente2.setNome("Martins");
		cliente2.setTelefone("(11) 92060-8765");
//		dao.insere(cliente);
//		dao.insere(cliente2);
//		
		Livro livro = new Livro();
//	referencia a tabela Livro join collumn com autor e forma a tabela escreve
		Livro livro2 = new Livro();
		
		List<Autor> autores = new ArrayList<Autor>(); // faço uma lista aqui
		List<Autor> autores2 = new ArrayList<Autor>();
		autores.add(autor); // adiciono Autor na lista aqui
		autores2.add(autor2);
		
		livro.setTitulo("A Ilha dos Mortos");
		livro.setPreco(59.90);
		livro.setEstoque(10);
		livro.setGenero(genero);
		livro.setAutores(autores);// adiciona na Entidade Livro a lista de Autor aqui
		
		livro2.setTitulo("A Floresta De Mãos e Dentes");
		livro2.setPreco(80.00);
		livro2.setEstoque(2);
		livro2.setGenero(genero2);
		livro2.setAutores(autores2);
		
//		dao.insere(livro);
//		dao.insere(livro2);
//		
//		Busca por id
//		Livro livroRetornado = dao.buscaPorId(Livro.class, 1);
//		System.out.println(livroRetornado.getId());
//		System.out.println(livroRetornado.getTitulo());
//		System.out.println(livroRetornado.getPreco());
//		System.out.println(livroRetornado.getEstoque());
//		System.out.println(livroRetornado.getGenero().getId());
//Busca todos
//		List<Livro> livros = new ArrayList<Livro>();
//      livros.add(dao.listar(Livro.class));
//		for (Livro li : livros) {
//			System.out.println("Id:" + li.getId());
//			System.out.println("Titulo:" + li.getTitulo());
//			System.out.println("Preço: " + li.getPreco());
//			System.out.println("Estoque: " + li.getEstoque());
//			System.out.println("Id Genero: " + li.getGenero().getId());
//		}

//		OU
//		dao.listar(Livro.class).forEach(x -> System.out.println(x.getId()));
//	Venda
		Venda venda = new Venda();
		venda.setClientes(cliente);
		venda.setData(LocalDate.now());
		venda.adicionaLivro(livro, 2);
		venda.adicionaLivro(livro2, 3);
//		dao.insere(venda);
//		dao.atualiza(livro);
//		dao.atualiza(livro2);
		
	}
}
