import xmlrpc.client as rpc

remoto = rpc.ServerProxy("tcp://localhost:8080")

x = int(input("digite um numero:"))
sucessor = remoto.sucessor(x)
antecessor = remoto.antecessor(x)
quadrado = remoto.quadrado(x)
raiz = remoto.raiz(x)

print(sucessor, antecessor, quadrado, raiz)
