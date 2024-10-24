import xmlrpc.client as rpc


if __name__ == '__main__':
    if len(sys.argv) < 3:
        porta=8080
    else:
        porta=int(sys.argv[2])
    if len(sys.argv) < 2:
        ip = 'localhost'
    else:
        ip=str(sys.argv[1])
        
    remoto = rpc.ServerProxy(f"http://{ip}:{porta}")

    x = int(input("digite um numero:"))
    sucessor = remoto.sucessor(x)
    antecessor = remoto.antecessor(x)
    quadrado = remoto.quadrado(x)
    raiz = remoto.raiz(x)

    print(sucessor, antecessor, quadrado, raiz)
