from socket import *

serverName = 'localhost'
serverPort = 5000
requestString = input("Input a sentence or 'Quit' to exit program: ")
while requestString != 'Quit':
    clientSocket = socket(AF_INET, SOCK_STREAM)
    clientSocket.connect((serverName, serverPort))
    clientSocket.send(requestString.encode())
    response = clientSocket.recv(1024)
    print(response.decode())
    clientSocket.close()
    requestString = input("Input a sentence or 'Quit' to exit program: ")
