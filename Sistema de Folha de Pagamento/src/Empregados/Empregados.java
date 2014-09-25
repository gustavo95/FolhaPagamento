package Empregados;

import java.util.Date;

public abstract class Empregados {

	private String nome;
	private String metodoPagamento;
	private String endereco;
	private int ID;
	private Sindicato sindicato;
	
	public Empregados(int ID, String nome, String endereco, String metodoPagamento){
		this.ID = ID;
		this.nome = nome;
		this.endereco = endereco;
		this.metodoPagamento = metodoPagamento;
		this.sindicato = new Sindicato();
	}
	
	public Empregados(Empregados e){
		this.ID = e.ID;
		this.nome = e.nome;
		this.endereco = e.endereco;
		this.metodoPagamento = e.metodoPagamento;
		this.sindicato = e.sindicato;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Sindicato getSindicato() {
		return sindicato;
	}
	public void setSindicato(Sindicato sindicato) {
		this.sindicato = sindicato;
	}
	
	public abstract void folhaPagamento(Date data);
	
}
