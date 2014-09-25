package Empregados;

import java.util.Calendar;
import java.util.Date;

public class Assalariados extends Empregados{

	protected double salarioFixo;
	
	public Assalariados(int ID, String nome, String endereco, String metodoPagamento, Double salarioFixo) {
		super(ID, nome, endereco, metodoPagamento);
		this.salarioFixo = salarioFixo;
		
	}
	
	public Assalariados(Assalariados a){
		super(a);
		this.salarioFixo = a.salarioFixo;
	}
	
	public double getSalarioFixo() {
		return salarioFixo;
	}
	public void setSalarioFixo(double salarioFixo) {
		this.salarioFixo = salarioFixo;
	}

	@Override
	public String toString() {
		return "\nID: " + getID() + "\nNome: " + getNome() + "\nTipo: Assalariado" + "\nMétodo de pagamento: " 
				+ getMetodoPagamento() + "\nEndereço: " + getEndereco() + "\nSalario fixo: " + salarioFixo;
	}

	@Override
	public void folhaPagamento(Date data) {
		double salarioLiquido;
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(data);
		int dia = cal.get(Calendar.DAY_OF_MONTH); 
		int ultimoDiaMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		if(dia == ultimoDiaMes){
			System.out.println(toString());
			
			salarioLiquido = salarioFixo;
			
			if(getSindicato().isPertence()){
				System.out.println(getSindicato().toString());
				salarioLiquido = salarioLiquido - getSindicato().getTaxaSindical() - getSindicato().getTaxaServicos();
				getSindicato().setTaxaServicos(0);
			}
			
			System.out.println("Salário liquido: " + salarioLiquido);
		}
		
	}

}
