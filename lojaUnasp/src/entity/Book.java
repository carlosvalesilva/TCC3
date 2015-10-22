package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the Book database table.
 * 
 */
@Entity


public class Book implements Serializable {
	private static final long serialVersionUID = 1L;


	private String descricao;
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	
	

	private int codigo;
	private String marca;
	private float valor;
	private float quantidade;
	

	

	public Book(String string, int i, String string2, String string3) {
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca= marca;
	}
	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
	public float getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	

	public Book(String descricao,  int codigo, String marca, float valor, float quantidade) {
		super();
		this.descricao = descricao;
		this.codigo = codigo;
		this.marca = marca;
		this.valor = valor;
		this.quantidade = quantidade;
		
	}

	
}