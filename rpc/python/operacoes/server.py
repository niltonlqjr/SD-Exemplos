import xmlrpc.server as rpc
import sys, socket

def sucessor(n):
    return n+1

def antecessor(n):
    return n-1

def quadrado(n):
    return n*n

def raiz(n):
    return n**0.5

if __name__ == '__main__':
    
    if len(sys.argv) < 3:
        porta=8080
    else:
        porta=int(sys.argv[2])
    if len(sys.argv) < 2:
        ip = 'localhost'
        print("nome de host definido como 'localhost', somente clientes locais serão atendidos.")
    else:
        ip=str(sys.argv[1])
    
        
    server = rpc.SimpleXMLRPCServer((ip,porta))
    server.register_function(sucessor)
    server.register_function(antecessor)
    server.register_function(quadrado)
    server.register_function(raiz)
    server.serve_forever()
    