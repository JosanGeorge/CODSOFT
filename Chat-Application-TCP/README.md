# Java Chat Server and Client

A simple Java implementation of a chat server and client using sockets.

## Overview

This project consists of two Java applications: `ChatServer` and `ChatClient`. The server listens for incoming connections, while the client connects to the server. Once connected, both the server and client can send and receive messages.

## Features

- Server listens on port 12345.
- Client connects to the server using the localhost and port 12345.
- Communication between the server and client is established through input and output streams.
- Messages are exchanged between the server and client.

## Usage

1. Compile the Java files:

```bash
javac ChatServer.java
javac ChatClient.java
```

2. Run the server:

```bash
java ChatServer
```

3. Run the client (open a new terminal or command prompt):

```bash
java ChatClient
```

4. Start chatting!

## Note

- The server and client use separate threads for receiving and sending messages.
- Messages are entered through the console.

## Contributors

- Josan George
- josangeorge27@gmail.com

Feel free to contribute to this project by opening issues or pull requests.
