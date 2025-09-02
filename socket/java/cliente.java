import java.io.*; 
import java.net.*; 

class ClienteTCP { 

    public static void main(String argv[]) throws Exception 
    { 
        String frase; 
        String fraseModificada;
        String server_address = "localhost";
        if(argv.length >= 1){
          System.err.println(argv[0]);
          server_address = argv[0];
        }
        
        BufferedReader doUsuario = 
          new BufferedReader(new InputStreamReader(System.in)); 

        try {  
          Socket socketCliente = new Socket(server_address, 6789); 
          
          DataOutputStream paraServidor = 
            new DataOutputStream(socketCliente.getOutputStream()); 

          BufferedReader doServidor = 
            new BufferedReader(new
            InputStreamReader(socketCliente.getInputStream())); 
          System.out.println("Digite a frase a ser enviada para o servidor:");
          frase = doUsuario.readLine(); 

          paraServidor.writeBytes(frase + '\n'); 

          fraseModificada = doServidor.readLine(); 

          System.out.println("Do Servidor: " + fraseModificada); 

          socketCliente.close();
        } catch (Exception e) {
          System.err.println("Erro de conexao com o servidor: "+server_address+".");
          System.exit(1);      
        } 
                   
    } 
} 
