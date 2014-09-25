package Empregados;

import java.util.Calendar;
import java.util.Date;

public class Comissionados extends Assalariados{
	
	private int percentualComissao;
	private double salarioComissao;
	private boolean primeiraSemana;
	
	public Comissionados(int ID, String nome, String endereco, String metodoPagamento, Double salarioFixo, int percentualComissao) {
		super(ID, nome, endereco, metodoPagamento, salarioFixo);
		this.percentualComissao = percentualComissao;
		this.salarioComissao = 0;
		this.primeiraSemana = true;
	}
	
	public Comissionados(Comissionados c){
		super(c);
		this.percentualComissao = c.percentualComissao;
		this.salarioComissao = c.salarioComissao;
		this.primeiraSemana = c.primeiraSemana;
	}

	public int getPercentualComissao() {
		return percentualComissao;
	}
	public void setPercentualComissao(int percentualComissao) {
		this.percentualComissao = percentualComissao;
	}
	
	public void resultadoVenda(double valor){
		salarioComissao += (valor * percentualComissao / 100);
	}
	
	@Override
	public String toString() {
		return "\nID: " + getID() + "\nNome: " + getNome() + "\nTipo: Comissionado" + "\nMétodo de pagamento: " 
				+ getMetodoPagamento() + "\nEndereço: " + getEndereco() + "\nSalario fixo: " + getSalarioFixo() 
				+ "\nComissão: "+ percentualComissao + "%\nSalario comissão: " + salarioComissao;
	}

	@Override
	public void folhaPagamento(Date data) {
		double salarioLiquido;
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(data);
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		
		if(dia == 6 && !primeiraSemana){
			System.out.println(toString());
			
			salarioLiquido = (getSalarioFixo()/2) + salarioComissao;
			salarioComissao = 0;
			primeiraSemana = true;
			
			if(getSindicato().isPertence()){
				System.out.println(getSindicato().toString());
				salarioLiquido = salarioLiquido - getSindicato().getTaxaSindical() - getSindicato().getTaxaServicos();
				getSindicato().setTaxaServicos(0);
			}
			
			System.out.println("Salário liquido: " + salarioLiquido);
		}else if(dia == 6 && primeiraSemana){
			primeiraSemana = false;
		}
		
	}

}
