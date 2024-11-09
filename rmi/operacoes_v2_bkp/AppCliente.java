import ClassesServer.ServerOperacoes;
import InterfacesRemotas.OperacoesRemote;
import java.util.Scanner;
import java.rmi.registry.*;

public class AppCliente {
    public static void main(String argv[]){
        String host = argv[0];
        Integer porta = argv.length >= 2? Integer.parseInt(argv[1]) : 1099;
        String objName = "Operacoes:"+porta.toString();
        OperacoesRemote remOp = new ServerOperacoes();

        try {
            Registry registry = LocateRegistry.getRegistry(host);
            remOp = (OperacoesRemote) registry.lookup(objName);
            System.out.println("objeto: '"+objName+"' localizado no servidor: "+host);
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        Scanner stdin = new Scanner(System.in);
        System.out.println("digite um numero:");
        String s = stdin.nextLine();
        Integer num = Integer.parseInt(s);
        stdin.close();

        Integer sucessor = 0;
        Integer antecessor = 0;
        Integer quadrado = 0; 
        Double raiz = 0.0;
        try {
            sucessor = remOp.sucessor(num);
            antecessor = remOp.antecessor(num);
            quadrado = remOp.quadrado(num);
            raiz = remOp.raiz(num);
                    
            System.out.println("Sucessor: "+sucessor.toString());
            System.out.println("Antecessor: "+antecessor.toString());
            System.out.println("Quadrado: "+quadrado.toString());
            System.out.println("Raiz: "+raiz.toString());
        } catch (Exception e) {
            System.out.println("impossivel crealizar chamada remota");
        }

    }
}
