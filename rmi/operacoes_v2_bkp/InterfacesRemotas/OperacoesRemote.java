package InterfacesRemotas;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OperacoesRemote extends Remote{
    public Integer sucessor(Integer x) throws RemoteException;
    public Integer antecessor(Integer x) throws RemoteException;
    public Integer quadrado(Integer x) throws RemoteException;
    public Double raiz(Integer x) throws RemoteException;
}
