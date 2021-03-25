from socket import *

serverName = 'localhost'
serverPort = 5000
clientSocket = socket(AF_INET, SOCK_DGRAM)
requestString = input("Input a sentence or 'Quit' to exit program: ")
while requestString != 'Quit':
    clientSocket.sendto(requestString.encode(), (serverName, serverPort))
    responseString, serverAddress = clientSocket.recvfrom(1024)
    print(responseString.decode())
    requestString = input("Input a sentence or 'Quit' to exit program: ")
clientSocket.close()
