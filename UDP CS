//UDPServer.java:
import java.net.*;
import java.io.*;
public class UDPServer {
public static void main(String[] args) {
try {
DatagramSocket serverSocket = new
DatagramSocket(9876);
byte[] receiveData = new byte[1024];
byte[] sendData;
System.out.println("UDP Server is running...");
while (true) {
DatagramPacket receivePacket = new
DatagramPacket(receiveData, receiveData.length);
serverSocket.receive(receivePacket);
String expression = new
String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Received expression: " +
expression);
String result = evaluateExpression(expression);
sendData = result.getBytes();
InetAddress clientAddress =
receivePacket.getAddress();

int clientPort = receivePacket.getPort();
DatagramPacket sendPacket = new
DatagramPacket(sendData, sendData.length, clientAddress,
clientPort);
serverSocket.send(sendPacket);
}
} catch (Exception e) {
e.printStackTrace();
}
}
// Method to evaluate arithmetic expressions
private static String evaluateExpression(String expression)
{
try {
String[] tokens = expression.split(" ");
if (tokens.length != 3) return "Invalid
Expression";
double num1 = Double.parseDouble(tokens[0]);
double num2 = Double.parseDouble(tokens[2]);
String operator = tokens[1];
double result;
switch (operator) {
case "+": result = num1 + num2; break;
case "-": result = num1 - num2; break;
case "*": result = num1 * num2; break;
case "/":
if (num2 == 0) return "Division by zero
error";
result = num1 / num2;
break;
default: return "Invalid Operator";
}

return String.valueOf(result);
} catch (Exception e) {
return "Error in expression";
}
}
}



UDPClient.java:
import java.net.*;
import java.util.Scanner;
public class UDPClient {
public static void main(String[] args) {
try {
DatagramSocket clientSocket = new DatagramSocket();
InetAddress serverAddress =
InetAddress.getByName("localhost");
byte[] sendData;
byte[] receiveData = new byte[1024];
Scanner scanner = new Scanner(System.in);
while (true) {
System.out.print("Enter arithmetic expression
(e.g., 5 + 3) or type 'exit' to quit: ");
String expression = scanner.nextLine();
if (expression.equalsIgnoreCase("exit")) {
System.out.println("Exiting...");
break;
}
sendData = expression.getBytes();

DatagramPacket sendPacket = new
DatagramPacket(sendData, sendData.length, serverAddress, 9876);
clientSocket.send(sendPacket);
DatagramPacket receivePacket = new
DatagramPacket(receiveData, receiveData.length);
clientSocket.receive(receivePacket);
String result = new
String(receivePacket.getData(), 0, receivePacket.getLength());
System.out.println("Server Result: " + result);
}
clientSocket.close();
scanner.close();
} catch (Exception e) {
e.printStackTrace();
}
}
}
