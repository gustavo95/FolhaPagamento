package Main;

import java.util.Scanner;

public class Menu{

	private int opt;
	private Scanner scan;

	public int menu1() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);

		System.out.println("\nEscolha a op��o");
		System.out.println("0. Fechar");
		System.out.println("1. Adi��o de um empregado");
		System.out.println("2. Remo��o de um empregado");
		System.out.println("3. Lan�ar um cart�o de ponto");
		System.out.println("4. Lan�ar um resultado venda");
		System.out.println("5. Lan�ar uma taxa de servi�o");
		System.out.println("6. Alterar detalhes de um empregado");
		System.out.println("7. Rodar a folha de pagamento para hoje");
		System.out.println("8. Undo");
		System.out.println("9. Redo");
		System.out.println("10. Imprimir empregados");
		System.out.println("11. Mudar data");

		opt = Integer.parseInt(scan.next());

		if(opt < 0 || opt > 11){
			System.err.println("Op��o invalida\n");
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
			System.err.println("Op��o invalida\n");
		}

		return opt;

	}
	
	public String menu3() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);

		do{
			System.out.println("M�todo de pagamento:");
			System.out.println("0. Cheque pelos correios");
			System.out.println("1. Cheque em m�os");
			System.out.println("2. Dep�sito em conta banc�ria");

			opt = Integer.parseInt(scan.next());

			if(opt < 0 || opt > 2){
				System.err.println("Op��o invalida\n");
			}

		}while(opt < 0 || opt > 2);
		
		String metodo = null;
		
		if(opt == 0){
			metodo = "Cheque pelos correios";
		}else if(opt == 1){
			metodo = "Cheque em m�os";
		}else if(opt == 2){
			metodo = "Dep�sito em conta banc�ria";
		}

		return metodo;

	}
	
	public int menu4() throws NumberFormatException, Exception{
		scan = new Scanner(System.in);


		System.out.println("\nAlterar");
		System.out.println("0. Nome");
		System.out.println("1. Endere�o");
		System.out.println("2. Tipo");
		System.out.println("3. Metodo de pagamento");
		System.out.println("4. Pertence ao sindicato");
		System.out.println("5. Identifica��o no sindicato");
		System.out.println("6. Taxa sindical");

		opt = Integer.parseInt(scan.next());

		if(opt < 0 || opt > 6){
			System.out.println("Op��o invalida\n");
		}

		return opt;
	}

}
