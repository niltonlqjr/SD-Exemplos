#include <stdio.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <stdlib.h>
#include <string.h>
#include <arpa/inet.h>

int main(int argc, char *argv[]){
    if(argc != 2){
        printf("Modo de usar\n");
        printf("%s <mensagem>",argv[0]);
        return 1;
    }
    char host[]="127.0.0.1";
    char *resp;
    unsigned int port=5050;
    struct sockaddr_in addr;
    int sockfd, len;

    addr.sin_family = AF_INET; 
    // familia do socket (AF_INET -> IPv4)
    addr.sin_port = htons(port); 
    // porta do socket (convertida para o formato correto da porta)
    addr.sin_addr.s_addr = inet_addr(host);
    //converte o endereco do server para o formato adequado
    
    sockfd = socket(AF_INET,  SOCK_STREAM, 0);

    connect(sockfd, (struct sockaddr *)&addr, sizeof(struct sockaddr));
    //conecta ao servidor especificado na struct addr
    len = strlen(argv[1]);
    send(sockfd, argv[1], len, 0);
    //envia o argumento para o servidor
    resp = (char *) malloc(len * sizeof(char));
    //aloca espaco em memoria para receber a resposta
    recv(sockfd, resp, len, 0);
    //recebe a resposta do servidor
    printf("Recebido do servidor: %s\n",resp);
    free(resp);
}