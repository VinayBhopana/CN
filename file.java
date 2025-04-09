//ChatClient:
import java.io.*;
import java.net.*;
public class ChatClient{
public static void main(String[] args) {

final String SERVER_ADDRESS = "127.0.0.1";
final int SERVER_PORT = 12345;
try(Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT)){
System.out.println("Connected to server.");
BufferedReader serverInput = new BufferedReader(new
InputStreamReader(socket.getInputStream()));
PrintWriter clientOutput = new PrintWriter(socket.getOutputStream(),
true);
BufferedReader clientInput = new BufferedReader(new
InputStreamReader(System.in));
String clientMessage, serverMessage;
System.out.println("Chat started. Type 'quit' to end.");
while(true){
System.out.println("Client: ");
clientMessage = clientInput.readLine();
clientOutput.println(clientMessage);
if(clientMessage.equalsIgnoreCase("quit")){
System.out.println("Chat ended");
break;
}
serverMessage = serverInput.readLine();
if(serverMessage == null ||
serverMessage.equalsIgnoreCase("quit")){
System.out.println("Server disconnected.");
break;
}
System.out.println("Server: " + serverMessage);
}
}
catch(IOException e){
System.err.println("Client error: " + e.getMessage());
}
}
}




//ChatServer:
import java.io.*;
import java.net.*;
public class ChatServer{
public static void main(String[] args) {
final int SERVER_PORT = 12345;
try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)){
System.out.println("Server started. Waiting for a client...");
Socket clientSocket = serverSocket.accept();
System.out.println("Client connected.");
BufferedReader clientInput = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
PrintWriter serverOutput = new
PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader serverInput = new BufferedReader(new
InputStreamReader(System.in));
String clientMessage, serverMessage;
System.out.println("Chat started. Type 'quit' to end.");
while(true){
clientMessage = clientInput.readLine();
if(clientMessage == null ||
clientMessage.equalsIgnoreCase("quit")){
System.out.println("Client disconnected.");
break;
}
System.out.println("Client: " + clientMessage);
System.out.println("Server: ");
serverMessage = serverInput.readLine();
serverOutput.println(serverMessage);
if(serverMessage.equalsIgnoreCase("quit")){
System.out.println("Client ended.");
break;
}
}
}

catch(IOException e){
System.err.println("Server error: " + e.getMessage());
}
}
}
