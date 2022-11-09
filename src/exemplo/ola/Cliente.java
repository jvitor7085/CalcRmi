package exemplo.ola;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {

	private Cliente() {
	}
static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		String host = (args.length < 1) ? null : args[0];

		try {
			
			//Obtém o stub para registro
			Registry registry = LocateRegistry.getRegistry(host);
			
			//Obtém o stub para o objeto remoto (Ola) do registro.
			Ola stub = (Ola) registry.lookup("Ola");

				
			//Invocação do método remoto
			String resposta = stub.digaOla();
			
			System.out.println("Resposta: " + resposta);
			
			while(true) {
				System.out.println("Bem vindo a calculadora");
				System.out.println("Qual operacao voce quer fazer?");
				System.out.println("Para soma escolha (1)");
				System.out.println("Para subtracao escolha (2)");
				System.out.println("Para multiplicacao escolha (3)");
				System.out.println("Para divisao escolha (4)");
				int opc = sc.nextInt();
				
				if (opc == 1) {
					System.out.println("Informe o primeiro numero da soma:");
					int num1 = sc.nextInt();
					System.out.println("Informe o segundo numero da soma:");
					int num2 = sc.nextInt();
					System.out.println("O resultado de " + num1 + "+" + num2 + "=" + stub.soma(num1, num2));
					break;
				}
				if (opc == 2) {
					System.out.println("Informe o primeiro numero da subtracao:");
					int num1 = sc.nextInt();
					System.out.println("Informe o segundo numero da subtracao:");
					int num2 = sc.nextInt();
					System.out.println("O resultado de " + num1 + "-" + num2 + "=" + stub.subtracao(num1, num2));
					break;
				}

				if (opc == 3) {
					System.out.println("Informe o primeiro numero da multiplicacao:");
					int num1 = sc.nextInt();
					System.out.println("Informe o segundo numero da multiplicacao:");
					int num2 = sc.nextInt();
					System.out.println("O resultado de " + num1 + "x" + num2 + "=" + stub.multiplicacao(num1, num2));
					break;
				}

				if (opc == 4) {
					System.out.println("Informe o primeiro numero da divisao:");
					Double num1 = sc.nextDouble();
					System.out.println("Informe o segundo numero da divisao:");
					Double num2 = sc.nextDouble();
					System.out.println("O resultado de " + num1 + "/" + num2 + "=" + stub.divisao(num1, num2));
					break;
				} else {
					System.out.println("escolha uma opcao valida");
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Exceção do cliente: " + e.toString());
		}
	}
}
