

```
# RMI Calculator

This is a simple calculator application that demonstrates the use of RMI (Remote Method Invocation) in Java. The application allows you to perform basic mathematical operations (addition, subtraction, multiplication, and division) remotely using RMI.

## Features

- Addition: Perform addition of two numbers.
- Subtraction: Perform subtraction of two numbers.
- Multiplication: Perform multiplication of two numbers.
- Division: Perform division of two numbers.

## Prerequisites

- Java Development Kit (JDK) installed on your system.
- Basic knowledge of Java and RMI.

## Getting Started

1. Clone the repository:

```
git clone https://github.com/your_username/rmi-calculator.git
```

2. Compile the Java files:

```
cd rmi-calculator
javac *.java
```

3. Start the RMI registry and the server:

```
start rmiregistry
java CalculatorServer
```

4. Launch the client application:

```
java CalculatorClient
```

5. Use the calculator GUI to perform mathematical operations.

## Troubleshooting

- If you encounter any issues related to RMI, make sure that the RMI registry and server are running properly before launching the client application.
- Ensure that there are no firewall restrictions preventing the communication between the client and server.
