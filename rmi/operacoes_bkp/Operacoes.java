
import java.rmi.Remote; 
import java.rmi.RemoteException; 

public interface Operacoes extends Remote { 
    public Integer sucessor(Integer x) throws RemoteException; 
}