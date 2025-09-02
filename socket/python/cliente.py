import socket
import sys

host='localhost'
port=5050

if len(sys.argv) <= 1:
    print("forma de usar:")
    print(sys.argv[0], "<mensagem> [server]")
    exit(1)
arg = sys.argv[1]
if len(sys.argv) > 2:
    host = sys.argv[2]
print(f'connectando com o servidor: {host}')
try:
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect((host, port))
    s.sendall(bytes(sys.argv[1], 'utf-8'))
    data = s.recv(1024)
    print('Mensagem recebida:', str(data, 'utf-8'))
except:
    print('erro ao conectar com o servidor')