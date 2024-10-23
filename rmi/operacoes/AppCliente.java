import ClassesServer.ServerOperacoes;
import InterfacesRemotas.OperacoesRemote;
import java.util.Scanner;
import java.rmi.registry.*;

public class AppCliente {
    public static void main(String argv[]){
        String host = argv[0];
        Integer porta;
        /* Definição do host e porta */
        if(argv.length < 1){
            host = "127.0.0.1";
        }else{
            host=argv[0];
        }
        if(argv.length < 2){
            porta = 1099;
        }else{
            porta = Integer.parseInt(argv[1]);
            
        }
        /* */
        String objName = "Operacoes:"+porta.toString();
        OperacoesRemote remOp = null;// = new ServerOperacoes();

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
        } catch (Exception e) {
            System.out.println("impossivel crealizar chamada remota");
            System.err.println(e);
            System.exit(1);
	}

        
        System.out.println("Sucessor: "+sucessor.toString());
        System.out.println("Antecessor: "+antecessor.toString());
        System.out.println("Quadrado: "+quadrado.toString());
        System.out.println("Raiz: "+raiz.toString());



    }
}
