import java.io.*; 
import java.net.*; 

class servidorTCP { 

  public static void main(String argv[]) throws Exception 
  { 
    String fraseCliente; 
    String fraseMaiusculas; 
    ServerSocket socketRecepcao = new ServerSocket(6789); 
    while(true) { 
      Socket socketConexao = socketRecepcao.accept(); 

      BufferedReader doCliente = 
          new BufferedReader(new
          InputStreamReader(socketConexao.getInputStream()));     

      DataOutputStream  paraCliente = 
          new DataOutputStream(socketConexao.getOutputStream()); 

        fraseCliente= doCliente.readLine(); 

        System.out.println("Frase recebida do cliente: "+fraseCliente);

        fraseMaiusculas= fraseCliente.toUpperCase() + '\n'; 

        paraCliente.writeBytes(fraseMaiusculas); 
    } 
  } 
} 
 
