package exemplo.ola;

import java.rmi.Remote;
import java.rmi.RemoteException;

//Interface precisa extender a classe Remote
public interface Ola extends Remote {
	
	//método digaOla() será chamado remotamente. É necessário lançar a exceção RemoteException
	String digaOla() throws RemoteException;

public int soma(int x, int y) throws RemoteException;
public int subtracao(int x, int y) throws RemoteException;
public Double divisao(Double num1, Double num2) throws RemoteException;
public int multiplicacao(int x, int y) throws RemoteException;

}


