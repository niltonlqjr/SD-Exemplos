#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <unistd.h>
#include <arpa/inet.h>
#include <sys/socket.h>
#include <netinet/in.h>

#define MAX_MESSAGE_SIZE 1024

int main(){

    char *peer_ip, income_data[MAX_MESSAGE_SIZE+1];// Soma 1 para o \0
    unsigned int port=5050;
    struct sockaddr_in addr, peer_addr;
    int sockfd, income_size, peer_sockfd;
    socklen_t peer_size;


    addr.sin_family = AF_INET; 
    // familia do socket (AF_INET -> IPv4)
    addr.sin_port = htons(port); 
    // porta do socket (convertida para o formato correto da porta)
    addr.sin_addr.s_addr = INADDR_ANY;
    //pega o proprio endereço para realizar a vinculação ao socket
    
    sockfd = socket(AF_INET,  SOCK_STREAM, 0);
    //cria um descritor de arquivo para o socket

    bind(sockfd,(struct sockaddr *)&addr, sizeof(struct sockaddr));
    //vincula o descritor de arquivo do socket com o endereço (e porta) locals 

    listen(sockfd, 1); 
    //esperando conexões, sendo o máximo de 1 na fila de entrada
    while(1){
        peer_sockfd = accept(sockfd, (struct sockaddr *)&addr, &peer_size);
        //aceita a conexão do cliente
        getpeername(peer_sockfd, (struct sockaddr *) &peer_addr, &peer_size);
        peer_ip = inet_ntoa(peer_addr.sin_addr);
        printf("conectado: %s %d\n",peer_ip, peer_addr.sin_port);

        income_size = recv(peer_sockfd, income_data, MAX_MESSAGE_SIZE, 0);
        printf("mensagem recebida: %s\n",income_data);

        for(int i=0;i<income_size;i++){
            income_data[i] = toupper(income_data[i]);
        }

        send(peer_sockfd,income_data,income_size, 0);
        close(peer_sockfd);
    }   

}