package Empregados;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Main.Menu;

public class ListaEmpregados {

	private List<Empregados> empregados;
	private int ID;
	private int IDSindicato;
	private Scanner scan;
	private Menu m;

	public ListaEmpregados(){
		empregados = new ArrayList<Empregados>();
		ID = 0;
		IDSindicato = 0;
	}

	public void addEmpregado() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);

		m = new Menu();
		int opt = m.menu2();

		ID++;
		System.out.println("Id: " + ID);
		System.out.print("Nome: ");
		String nome = scan.nextLine();
		System.out.print("Endereço: ");
		String endereco = scan.nextLine();
		String metodoPagamento = m.menu3();

		if(opt == 0){
			System.out.print("Salário por hora: ");
			double salarioHora = Double.parseDouble(scan.nextLine());

			Horistas novoEmpregado = new Horistas(ID, nome, endereco, metodoPagamento, salarioHora);
			empregados.add(novoEmpregado);
		}else if(opt == 1){
			System.out.print("Salário fixo: ");
			double salarioFixo = Double.parseDouble(scan.nextLine());

			Assalariados novoEmpregado = new Assalariados(ID, nome, endereco, metodoPagamento, salarioFixo);
			empregados.add(novoEmpregado);
		}else if(opt == 2){
			System.out.print("Salário fixo: ");
			Double salarioFixo = Double.parseDouble(scan.nextLine());
			System.out.print("Comissão: ");
			int percentualComissao = Integer.parseInt(scan.nextLine());

			Comissionados novoEmpregado = new Comissionados(ID, nome, endereco, metodoPagamento, salarioFixo, percentualComissao);
			empregados.add(novoEmpregado);
		}

	}

	public int buscarEmpregado() throws Exception{
		int indice = -1;
		scan = new Scanner(System.in);

		System.out.print("Nome do empregado: ");
		String nome = scan.nextLine();

		for(int i = 0; i < empregados.size(); i++){

			if(nome.compareTo(empregados.get(i).getNome()) == 0){
				indice = i;
				i = empregados.size();
			}
		}

		if(indice == -1){
			System.err.println("Empregado não encontrado!");
		}

		return indice;
	}

	public void removerEmpregado()throws Exception{
		int indice = buscarEmpregado();

		if(indice != -1){
			empregados.remove(indice);
			System.out.println("Empregado removido!");
		}
	}

	public void lancarCartaoPonto() throws NumberFormatException, ParseException, Exception{
		int indice = buscarEmpregado();
		scan = new Scanner(System.in);

		if(indice != -1){
			if(empregados.get(indice) instanceof Horistas){
				DateFormat df = new SimpleDateFormat("HH:mm");
				System.out.print("Hora inicial(hh:mm): ");  
				String dataRecebida = scan.nextLine(); 
				Date dataInicial = df.parse(dataRecebida);
				System.out.print("Hora final(hh:mm): ");
				dataRecebida = scan.nextLine();     
				Date dataFinal = df.parse(dataRecebida);

				Horistas horista = (Horistas)empregados.get(indice);
				horista.cartaoPonto(dataInicial, dataFinal);

			}else{
				System.out.println("Este empregado não é horista!");
			}
		}
	}

	public void lancarResultadoVenda() throws NumberFormatException, Exception{
		int indice = buscarEmpregado();

		if(indice != -1){
			if(empregados.get(indice) instanceof Comissionados){
				System.out.print("Valor da venda: ");
				double valor = Double.parseDouble(scan.nextLine());

				Comissionados comissionado = (Comissionados)empregados.get(indice);
				comissionado.resultadoVenda(valor);

			}else{
				System.out.println("Este empregado não é comissionado!");
			}
		}
	}

	public void lancarTaxaServico() throws NumberFormatException, Exception{
		int indice = buscarEmpregado();

		if(indice != -1){
			if(empregados.get(indice).getSindicato().isPertence() == true){
				System.out.print("Valor da taxa de serviço: ");
				empregados.get(indice).getSindicato().setTaxaServicos(Double.parseDouble(scan.nextLine()));
			}else{
				System.out.println("Empregado não pertence ao sindicato");
			}
		}
	}

	public void alterarDetalhes() throws NumberFormatException, Exception{
		int indice = buscarEmpregado();
		scan = new Scanner(System.in);

		if(indice != -1){
			int opt = m.menu4();

			if(opt == 0){
				System.out.print("Nome: ");
				empregados.get(indice).setNome(scan.nextLine());
			}
			if(opt == 1){
				System.out.print("Endereço: ");
				empregados.get(indice).setEndereco(scan.nextLine());
			}
			if(opt == 2){
				alterarTipo(indice);
			}
			if(opt == 3){
				m = new Menu();
				empregados.get(indice).setMetodoPagamento(m.menu3());
			}
			if(opt == 4){
				if(empregados.get(indice).getSindicato().isPertence()){
					empregados.get(indice).setSindicato(new Sindicato());
				}else{
					System.out.print("Taxa sindical: ");
					empregados.get(indice).setSindicato(new Sindicato(++IDSindicato, Double.parseDouble(scan.nextLine())));
				}
			}
			if(opt == 5){
				if(empregados.get(indice).getSindicato().isPertence()){
					System.out.print("Identificação no sindicato: ");
					empregados.get(indice).getSindicato().setID(Integer.parseInt(scan.nextLine()));
				}else{
					System.out.println("Empregado não pertence ao sindicato");
				}

			}
			if(opt == 6){
				if(empregados.get(indice).getSindicato().isPertence()){
					System.out.print("Taxa sindical: ");
					empregados.get(indice).getSindicato().setTaxaSindical(Double.parseDouble(scan.nextLine()));
				}else{
					System.out.println("Empregado não pertence ao sindicato");
				}

			}
		}
	}

	public void alterarTipo(int indice) throws NumberFormatException, Exception{
		int opt = m.menu2();
		scan = new Scanner(System.in);

		if(indice != -1){
			if(opt == 0 && !(empregados.get(indice) instanceof Horistas)){
				System.out.print("Salário por hora: ");
				double salarioHora = Double.parseDouble(scan.nextLine());

				Horistas alterarEmpregado = new Horistas(empregados.get(indice).getID(), empregados.get(indice).getNome(),
						empregados.get(indice).getEndereco(), empregados.get(indice).getMetodoPagamento(), salarioHora);
				
				empregados.remove(indice);
				empregados.add(alterarEmpregado);
			}else if(opt == 0){
				System.out.println("Empregado já é horista");
			}
			if(opt == 1 && (empregados.get(indice) instanceof Horistas || empregados.get(indice) instanceof Comissionados)){
				System.out.print("Salário fixo: ");
				Double salarioFixo = Double.parseDouble(scan.nextLine());

				Assalariados alterarEmpregado = new Assalariados(empregados.get(indice).getID(), empregados.get(indice).getNome(),
						empregados.get(indice).getEndereco(), empregados.get(indice).getMetodoPagamento(), salarioFixo);
				
				empregados.remove(indice);
				empregados.add(alterarEmpregado);
			}else if(opt == 1){
				System.out.println("Empregado já é assalariado");
			}
			if(opt == 2 && !(empregados.get(indice) instanceof Comissionados)){
				System.out.print("Salário fixo: ");
				Double salarioFixo = Double.parseDouble(scan.nextLine());
				System.out.print("Comissão: ");
				int percentualComissao = Integer.parseInt(scan.nextLine());

				Comissionados alterarEmpregado = new Comissionados(empregados.get(indice).getID(), empregados.get(indice).getNome(),
						empregados.get(indice).getEndereco(), empregados.get(indice).getMetodoPagamento(), salarioFixo, percentualComissao);
				
				empregados.remove(indice);
				empregados.add(alterarEmpregado);
			}else if(opt == 2){
				System.out.println("Empregado já é comissionado");
			}
		}
	}

	public void rodarFolhaPagamento(Date data) throws Exception{
		System.out.println("Empregados pagos:");
		for(Empregados temp : empregados){
			temp.folhaPagamento(data);
		}
	}

	public List<Empregados> getEmpregados(){
		return empregados;
	}

	public void setEmpregados(List<Empregados> empregados){
		this.empregados = empregados;
	}

	public void imprimirEmpregados(){
		System.out.println("Empregados:");
		for(Empregados temp : empregados){
			System.out.println(temp.toString());
		}
	}

}
