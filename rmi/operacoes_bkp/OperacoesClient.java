
import java.rmi.Naming; 

import java.util.Scanner;

public class OperacoesClient {
    public static void main(String argv[]){
        Operacoes rObj = null;
        for(int i=0; i<argv.length; i++)
            System.out.println(argv[i]);
        String host = argv[argv.length-1];
        try {
            String obj = new String("rmi://"+host+":1099/OperacoesServer");
            rObj = (Operacoes) Naming.lookup(obj);
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Digite um numero inteiro");
        Integer x = keyboard.nextInt();
        try {
            Integer s = rObj.sucessor(x);
            System.out.println(s);
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
