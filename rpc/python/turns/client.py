import xmlrpc.client as rpc
import sys


def thread_msgs():
    global server
    global id
    global running
    while running:
        print(server.download_message(id))


if __name__ == '__main__':
    if len(sys.argv) < 2:
        uri = 'localhost:8080'
    else:
        uri=str(sys.argv[1])
    print("oi")
    server = rpc.ServerProxy(f"http://{uri}")
    id = server.get_id()
    pair = (id+1)%2
    running = True

    print(id)

    while True:
        print("aguardando turno")
        turn_id = server.get_turn()
        if turn_id == id:
            val = input("> ")
            server.play(val, id)
        else:
            resp=server.wait_turn(id)
            print(resp)
        