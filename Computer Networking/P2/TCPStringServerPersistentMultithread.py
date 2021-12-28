from socket import *
import threading

#Thread Response to Client
def response(conn):
    while True:
        requestString = conn.recv(1024).decode()
        print(requestString) 
        if requestString == "Quit":
            conn.close()
            break
        else:
            responseString = requestString.upper()
            conn.send(responseString.encode())
    return

#Thread Class
class StartThread(threading.Thread):
    def __init__(self, conn): # let the constructor have parameters.
        self.conn = conn
        threading.Thread.__init__(self)

    def run(self):
        response(self.conn)


#Create Listening TCP Socket
serverPort = 5000
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print("The TCP server is ready.")

#Retrieve connection then create new thread to respond to client
while True:
    connectionSocket, addr = serverSocket.accept()

    thread = StartThread(connectionSocket)
    thread.start()

    
