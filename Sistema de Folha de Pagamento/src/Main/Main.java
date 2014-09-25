package Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Empregados.ListaEmpregados;

public class Main {

	private static Scanner scan;

	public static void main(String[] args) {

		ListaEmpregados empregados = new ListaEmpregados();

		Menu m = new Menu();
		UndoRedo UR = new UndoRedo();
		Date data = new Date();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		int opt = 12;

		System.out.println("\tSitema de Folha de Pagamento");
		System.out.println(df.format(data));

		do{
			try{
				opt = m.menu1();

				switch (opt){
				case 1:
					empregados.addEmpregado();
					UR.add(empregados.getEmpregados());
					break;

				case 2:
					empregados.removerEmpregado();
					UR.add(empregados.getEmpregados());
					break;

				case 3:
					empregados.lancarCartaoPonto();
					UR.add(empregados.getEmpregados());
					break;

				case 4:
					empregados.lancarResultadoVenda();
					UR.add(empregados.getEmpregados());
					break;

				case 5:
					empregados.lancarTaxaServico();
					UR.add(empregados.getEmpregados());
					break;

				case 6:
					empregados.alterarDetalhes();
					UR.add(empregados.getEmpregados());
					break;

				case 7:
					empregados.rodarFolhaPagamento(data);
					UR.add(empregados.getEmpregados());
					break;

				case 8:
					empregados.setEmpregados(UR.undo());
					break;

				case 9:
					empregados.setEmpregados(UR.redo());
					break;

				case 10:
					empregados.imprimirEmpregados();
					break;

				case 11:
					scan = new Scanner(System.in);
					System.out.print("Data(dd/mm/aaaa): ");
					String dataRecebida = scan.nextLine();     
					data = df.parse(dataRecebida);
					break;

				}
			}catch(NumberFormatException e){
				System.err.println("Você digitou um valor invalido. " + e.getMessage());
			}catch(ParseException e){
				System.err.println("Formato de data ou hora invalido. " + e.getMessage());
			}catch(Exception e){
				System.err.println("Erro inesperado. " + e.getMessage());
			}

		}while(opt != 0);

	}

}
