

import java.rmi.Naming;


public class ExecOperacoesServer {
    public ExecOperacoesServer(){
        try{
            OperacoesServer s = new OperacoesServer();
            Naming.rebind("rmi://localhost:1099/OperacoesServer", s);
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void main(String[] args) {
        new ExecOperacoesServer();
    }
}
