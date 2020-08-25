package br.com.qintess.comercioLivraria.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Venda {
	// atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate data;

	private double total;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente clientes;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LivroVenda> livros = new ArrayList<LivroVenda>();

	// alimenta itens_da_venda
	public void adicionaLivro(Livro livro, int qtd) {
		LivroVenda livroVenda = new LivroVenda(livro, this, qtd);
		// relacionamento bilateral
		livros.add(livroVenda);
		livro.getVendas().add(livroVenda);
		// atualiza o total
		double subtotal = qtd * livro.getPreco();
		livroVenda.setSubtotal(subtotal);

		this.total += subtotal;
		// atualiza o estoque
		livro.alteraEstoque(qtd);
	}

	// metodos especiais
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Cliente getClientes() {
		return clientes;
	}

	public void setClientes(Cliente clientes) {
		this.clientes = clientes;
	}

	public List<LivroVenda> getLivros() {
		return livros;
	}

	public void setLivros(List<LivroVenda> livros) {
		this.livros = livros;
	}

}
