package Main;

import java.util.Scanner;

public class Menu{

	private int opt;
	private Scanner scan;

	public int menu1() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);

		System.out.println("\nEscolha a opção");
		System.out.println("0. Fechar");
		System.out.println("1. Adição de um empregado");
		System.out.println("2. Remoção de um empregado");
		System.out.println("3. Lançar um cartão de ponto");
		System.out.println("4. Lançar um resultado venda");
		System.out.println("5. Lançar uma taxa de serviço");
		System.out.println("6. Alterar detalhes de um empregado");
		System.out.println("7. Rodar a folha de pagamento para hoje");
		System.out.println("8. Undo");
		System.out.println("9. Redo");
		System.out.println("10. Imprimir empregados");
		System.out.println("11. Mudar data");

		opt = Integer.parseInt(scan.next());

		if(opt < 0 || opt > 11){
			System.err.println("Opção invalida\n");
		}

		return opt;
	}
	
	public int menu2() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);


		System.out.println("\nTipo de empregado");
		System.out.println("0. Horista");
		System.out.println("1. Assalariado");
		System.out.println("2. Comissionado");

		opt = Integer.parseInt(scan.next());

		if(opt < 0 || opt > 2){
			System.err.println("Opção invalida\n");
		}

		return opt;

	}
	
	public String menu3() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);

		do{
			System.out.println("Método de pagamento:");
			System.out.println("0. Cheque pelos correios");
			System.out.println("1. Cheque em mãos");
			System.out.println("2. Depósito em conta bancária");

			opt = Integer.parseInt(scan.next());

			if(opt < 0 || opt > 2){
				System.err.println("Opção invalida\n");
			}

		}while(opt < 0 || opt > 2);
		
		String metodo = null;
		
		if(opt == 0){
			metodo = "Cheque pelos correios";
		}else if(opt == 1){
			metodo = "Cheque em mãos";
		}else if(opt == 2){
			metodo = "Depósito em conta bancária";
		}

		return metodo;

	}
	
	public int menu4() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);


		System.out.println("\nAlterar");
		System.out.println("0. Nome");
		System.out.println("1. Endereço");
		System.out.println("2. Tipo");
		System.out.println("3. Metodo de pagamento");
		System.out.println("4. Pertence ao sindicato");
		System.out.println("5. Identificação no sindicato");
		System.out.println("6. Taxa sindical");

		opt = Integer.parseInt(scan.next());

		if(opt < 0 || opt > 6){
			System.out.println("Opção invalida\n");
		}

		return opt;
	}

}
