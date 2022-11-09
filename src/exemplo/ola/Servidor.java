package exemplo.ola;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements Ola {

	public Servidor() {
	}

	public String digaOla() {
		return "Olá Mundo!";
	}

	public int soma(int x, int y) {
		return x + y;
	}

	public int subtracao(int x, int y) {
		return x - y;
	}

	public Double divisao(Double x, Double y) {
		if (x != 0 && y != 0)
			return (double) (x / y);

		else {
			System.out.println("divisao por 0 não existe, impossivel fazer a operação");
			return 0.0;
		}

	}

	public int multiplicacao(int x, int y) {
		return x * y;
	}

	public static void main(String[] args) {
		try {

			// Criação do objeto remoto
			Servidor obj = new Servidor();

			// Exportação do objeto remoto.
			Ola stub = (Ola) UnicastRemoteObject.exportObject(obj, 0);

			// Registro do objeto remoto com RMI Registry.
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Ola", stub);

			System.err.println("Servidor está pronto...");

		} catch (Exception e) {
			System.err.println("Exceção no Servidor:" + e.toString());
			e.printStackTrace();
		}
	}


}