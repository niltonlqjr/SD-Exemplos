import ClassesServer.ServerOperacoes;
import InterfacesRemotas.OperacoesRemote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class AppServer{
    public static void main(String argv[]){
        Integer porta;
        String hostname;
        if(argv.length < 1){
            porta = 1099;
        }else{
            porta = Integer.valueOf(argv[0]);
        }
        if(argv.length < 2){
            hostname = "127.0.0.1";
        }else{
            hostname=argv[1];
        }
        String objName = "Operacoes:"+porta.toString();
        OperacoesRemote op = new ServerOperacoes();
	    

        /*
         * A propriedade java.rmi.server.hostname da máquina virtual java
         * representa o nome que deve ser associado aos stubs dos clientes
         * para que eles possam se vicular ao servidor.
         */
        System.setProperty("java.rmi.server.hostname", hostname); 

        try {
            op = (OperacoesRemote) UnicastRemoteObject.exportObject(op,0);
        } catch (RemoteException e) {
            System.err.println("erro ao vincular objeto ");
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
