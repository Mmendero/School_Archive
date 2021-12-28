from socket import *

serverPort = 5000
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print("The TCP server is ready.")
while True:
    connectionSocket, addr = serverSocket.accept()
    while True:
        requestString = connectionSocket.recv(1024).decode()
        print(requestString) 
        if requestString == "QUIT":
            connectionSocket.close()
            break
        else:
            responseString = requestString.upper()
            connectionSocket.send(responseString.encode())
    print("Connection Socket Closed")
