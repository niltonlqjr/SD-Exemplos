import socket

host="" # todos hosts
port=5050

s = socket.socket(socket.AF_INET, # familia do socket (AF_INET -> DNS ou ip v4)
                  socket.SOCK_STREAM)
s.bind((host, port))
s.listen(1)
while True:
    connection, addr = s.accept()    
    print('Conectado:', addr)
    rec_data = connection.recv(1024)
    str_msg=str(rec_data,"utf-8")
    print('Mensagem Recebida (binaria):',rec_data)
    str_data = str_msg.upper()
    connection.send(bytes(str_data,"utf-8"))
    connection.close()

