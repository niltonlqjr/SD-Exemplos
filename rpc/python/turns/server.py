import xmlrpc.server as rpc
import sys, threading



def pair_id(id):
    return (id+1) % 2

def get_turn():
    global turno
    return turno

def play(jogada, id):
    global turno
    global barrier
    p = pair_id(id)
    jogadas[id].append(jogada)
    turno = p
    barrier.wait()
    return None

def wait_turn(id):
    global barrier
    global turno
    global jogadas
    p = pair_id(id)
    barrier.wait()
    ret = jogadas[p][0]
    del jogadas[p][0]
    return ret
    

def get_id():
    global id
    global barrier
    ret_id = id
    id += 1
    barrier.wait()
    return ret_id

class MultithreadSimpleXMLRPCServer():
    def __init__(self, server, n = 2):
        self.server = server
        self.nth = n
        self.threads = []
        self.barrier = threading.Barrier(n)


    def thread_request(self):
        while True:
            self.server.handle_request()
            self.barrier.wait()
    
    def create_threads(self,  func = None):
        if func == None:
            func = self.thread_request
        for i in range(self.nth):
            self.threads.append(threading.Thread(target=func))

    def start(self):        
        for i in range(self.nth):
            self.threads[i].start()

    def join(self):
        for i in range(self.nth):
            self.threads[i].join()

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
    
    jogadas = [[],[]]
    id = 0
    barrier = threading.Barrier(2)
    turno = 0
    

    server_info=(ip,porta)
    server = rpc.SimpleXMLRPCServer(server_info, allow_none=True)

    server.register_function(get_id)
    server.register_function(get_turn)
    server.register_function(play)
    server.register_function(wait_turn)
    
    #threads.append(threading.Thread(target=server.serve_forever, args=()))
    #threads.append(threading.Thread(target=server.serve_forever, args=()))


    th_wait1 = threading.Thread(target=server.handle_request)
    th_wait2 = threading.Thread(target=server.handle_request)
    th_wait1.start()
    th_wait2.start()
    th_wait1.join()
    th_wait2.join()

    ts = MultithreadSimpleXMLRPCServer(server=server, n=2)
    ts.create_threads()
    ts.start()
    ts.join()

