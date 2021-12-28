from socket import *

serverName = 'localhost'
serverPort = 5000

clientSocket = socket(AF_INET, SOCK_STREAM)
clientSocket.connect((serverName, serverPort))

while True:
    requestString = input("Input a sentence or 'Quit' to exit program: ")
    clientSocket.send(requestString.encode())
    
    if requestString == 'QUIT':
        break
    else:
        response = clientSocket.recv(1024)
        print(response.decode())

clientSocket.close()