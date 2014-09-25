package Empregados;

import java.util.Calendar;
import java.util.Date;

public class Horistas extends Empregados{

	private double salarioHora;
	private int horasTrabalhadas;
	private int horasExtras;
	
	public Horistas(int ID, String nome, String endereco, String metodoPagamento, Double salarioHora) {
		super(ID, nome, endereco, metodoPagamento);
		this.salarioHora = salarioHora;
		this.horasTrabalhadas = 0;
		this.horasExtras = 0;
	}
	
	public Horistas(Horistas h){
		super(h);
		this.salarioHora = h.salarioHora;
		this.horasTrabalhadas = h.horasTrabalhadas;
		this.horasExtras = h.horasExtras;
	}

	public double getSalarioHora() {
		return salarioHora;
	}
	public void setSalarioHora(double salarioHora) {
		this.salarioHora = salarioHora;
	}	
	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}
	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}
	public int getHorasExtras() {
		return horasExtras;
	}

	public void setHorasExtras(int horasExtras) {
		this.horasExtras = horasExtras;
	}

	public void cartaoPonto(Date dataInicial, Date dataFinal){
		long horas = (dataFinal.getTime() - dataInicial.getTime()) / 3600000 ;
		
		if(horas > 8){
			horasTrabalhadas += 8;
			horasExtras += (horas - 8);
		} else{
			horasTrabalhadas += horas;
		}
	}

	@Override
	public String toString() {
		return  "\nID: " + getID() + "\nNome: " + getNome() + "\nTipo: Horista" + "\nMétodo de pagamento: " 
				+ getMetodoPagamento() + "\nEndereço: " + getEndereco() + "\nSalario por hora: " + salarioHora 
				+ "\nHoras trabalhadas: " + horasTrabalhadas + "\nHoras extras: " + horasExtras;
	}

	@Override
	public void folhaPagamento(Date data) {
		double salarioLiquido;
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(data);
		int dia = cal.get(Calendar.DAY_OF_WEEK);
		
		if(dia == 6){
			System.out.println(toString());
			
			salarioLiquido = (horasTrabalhadas + (horasExtras * 1.5)) * salarioHora;
			horasTrabalhadas = 0;
			horasExtras = 0;
			
			if(getSindicato().isPertence()){
				System.out.println(getSindicato().toString());
				salarioLiquido = salarioLiquido - getSindicato().getTaxaSindical() - getSindicato().getTaxaServicos();
				getSindicato().setTaxaServicos(0);
			}
			
			System.out.println("Salário liquido: " + salarioLiquido);
		}
		
	}
	
}
