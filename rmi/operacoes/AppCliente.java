import InterfacesRemotas.OperacoesRemote;
import java.util.Scanner;
import java.rmi.registry.*;

public class AppCliente {
    public static void main(String argv[]){
        String host="";
        Integer porta;
        /* Definição do host e porta */
        if(argv.length < 1){
            System.out.println("Modo de usar:");
            System.out.println("java AppCliente <hostname> [porta]");
            System.out.println("<hostname>: é nome do servidor na rede.");
            System.out.println("[porta]: opcional - Porta para acessar o rmiregistry do servidor (padrão 1099)");
            System.exit(1);
        }else{
            host=argv[0];
        }
        if(argv.length < 2){
            porta = 1099;
        }else{
            porta = Integer.parseInt(argv[1]);
            
        }
        /* definicao do nome do objeto remoto */
        String objName = "Operacoes:"+porta.toString();
        OperacoesRemote remOp = null;
        /* conexao ao objeto remoto */
        try {
            Registry registry = LocateRegistry.getRegistry(host,porta);
            remOp = (OperacoesRemote) registry.lookup(objName);
            System.out.println("objeto: '"+objName+"' localizado no servidor: "+host);
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        /* leitura da entrada */
        Scanner stdin = new Scanner(System.in);
        System.out.println("digite um numero:");
        String s = stdin.nextLine();
        Integer num = Integer.parseInt(s);
        stdin.close();
        /* chamada dos metodos remotos */
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
