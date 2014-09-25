package Empregados;

public class Sindicato {
	
	private boolean pertence;
	private int ID;
	private double taxaSindical;
	private double taxaServicos;
	
	public Sindicato(){
		this.pertence = false;
		this.ID = 0;
		this.taxaSindical = 0;
		this.taxaServicos = 0;
	}
	
	public Sindicato(int ID, double taxaSindical){
		this.pertence = true;
		this.ID = ID;
		this.taxaSindical = taxaSindical;
		this.taxaServicos = 0;
	}

	public boolean isPertence() {
		return pertence;
	}

	public void setPertence(boolean pertence) {
		this.pertence = pertence;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getTaxaSindical() {
		return taxaSindical;
	}

	public void setTaxaSindical(double taxaSindical) {
		this.taxaSindical = taxaSindical;
	}

	public double getTaxaServicos() {
		return taxaServicos;
	}

	public void setTaxaServicos(double taxaServicos) {
		this.taxaServicos += taxaServicos;
	}

	@Override
	public String toString() {
		return "ID no sindicato: " + ID + "\nTaxa Sindical: " + taxaSindical
				+ "\nTaxa de serviço: " + taxaServicos;
	}

}
