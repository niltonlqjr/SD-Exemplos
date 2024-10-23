package ClassesServer;

import java.rmi.RemoteException;


import InterfacesRemotas.*;


public class ServerOperacoes implements OperacoesRemote{
    public Integer sucessor(Integer x) throws RemoteException{
        return x+1;
    }
    public Integer antecessor(Integer x) throws RemoteException{
        return x-1;
    }
    public Integer quadrado(Integer x) throws RemoteException{
        return x*x;
    }
    public Double raiz(Integer x) throws RemoteException{
        return Math.sqrt(x);
    }
}
