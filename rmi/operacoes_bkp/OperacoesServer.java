
import java.rmi.RemoteException; 
import java.rmi.server.UnicastRemoteObject; 


public class OperacoesServer extends UnicastRemoteObject implements Operacoes{
    public OperacoesServer() throws RemoteException{
        super();
    }
    public Integer sucessor(Integer x) throws RemoteException{
        return x+1;
    }
}
