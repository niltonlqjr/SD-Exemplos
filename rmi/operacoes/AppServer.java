import ClassesServer.ServerOperacoes;
import InterfacesRemotas.OperacoesRemote;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


public class AppServer{
    public static void main(String argv[]){
        Integer porta;
        String hostname="";
        /* Definição do hostname e porta */
        if(argv.length < 1){
            System.out.println("Modo de usar:");
            System.out.println("java AppServer <hostname> [porta]");
            System.out.println("<hostname>: é o nome usado na rede para encontrar este servidor.");
            System.out.println("[porta]: opcional - Porta utilizada pelo rmiregistry (será usada no nome do objeto)");
            System.exit(1);
        }else{
            hostname=argv[0];
        }
        if(argv.length < 2){
            porta = 1099;
        }else{
            porta = Integer.valueOf(argv[1]);
        }


        /* Definição do nome do objeto */
        String objName = "Operacoes:"+porta.toString();
        OperacoesRemote op = new ServerOperacoes();
	    

        /*
         * Alteração da propriedad hostname na JVM que roda este processo
         * A propriedade java.rmi.server.hostname da máquina virtual java
         * representa o nome que deve ser associado aos stubs dos clientes
         * para que eles possam se vicular ao servidor.
         * É comum utilizar o ip da máquina na rede, ou algum outro nome
         * para a máquina que seja visivel pelos clientes.
         */
        System.setProperty("java.rmi.server.hostname", hostname); 

        /* Exportando o objeto remoto */
        try {
            op = (OperacoesRemote) UnicastRemoteObject.exportObject(op,0);
        } catch (RemoteException e) {
            System.err.println("erro ao vincular objeto ");
            e.printStackTrace();
            System.exit(1);
        }

        /* Registrando o objeto remoto no rmiregisty */
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
