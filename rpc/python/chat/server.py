import xmlrpc.server as rpc
import sys, threading



def get_id():
    global id
    ret_id = id
    id += 1
    return ret_id

def upload_message(msg, to_id):
    global messages
    global semaphores
    try:
        semaphores[to_id].acquire()
        messages[to_id].append(msg)
        semaphores[to_id].release()
        return True
    except:
        return False

def download_message(id):
    global messages
    global semaphores
    try:
        semaphores[id].acquire()
        ret = messages[id][0]
        del messages[id][0]
        semaphores[id].release()
    except:
        ret = ''
    return ret


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

    
    messages = [[],[]]
    id = 0
    semaphores = [threading.Semaphore(0), threading.Semaphore(0)]
    

    server_info=(ip,porta)
    server = rpc.SimpleXMLRPCServer(server_info)

    server.register_function(get_id)
    server.register_function(upload_message)
    server.register_function(download_message)
    
    server.serve_forever()