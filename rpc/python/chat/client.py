import xmlrpc.client as rpc
import sys, threading




if __name__ == '__main__':
    if len(sys.argv) < 2:
        uri = 'localhost:8080'
    else:
        uri=str(sys.argv[1])
    
    server = rpc.ServerProxy(f"http://{uri}")

    id = server.get_id()
    pair = (id+1)%2
    msg = input("> ")
    while msg != '':
        server.upload_message(msg, pair)
        print(server.download_message(id))
        msg = input("> ")
    
