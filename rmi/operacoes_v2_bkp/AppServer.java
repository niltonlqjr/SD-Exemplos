import ClassesServer.ServerOperacoes;
import InterfacesRemotas.OperacoesRemote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class AppServer{
    public static void main(String argv[]){
        Integer porta;
        System.setProperty("java.rmi.server.hostname", "10.30.11.43");
        if(argv.length < 1){
            porta = 0;
        }else{
            porta = Integer.valueOf(argv[0]);
        }
        String objName = "Operacoes:"+porta.toString();
        OperacoesRemote op = new ServerOperacoes();

        try {
            op = (OperacoesRemote) UnicastRemoteObject.exportObject(op, porta);
        } catch (RemoteException e) {
            System.err.println("erro ao vincular objeto na porta" + porta.toString());
            e.printStackTrace();
            System.exit(1);
        }

        try {
            Registry regOP = LocateRegistry.getRegistry();
            regOP.bind(objName, op);
            System.out.println(objName + " registrado no servidor");
        } catch (Exception e) {
            System.err.println("Impossivel registrar o objeto");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}