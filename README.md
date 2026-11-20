
*This project was created as a lightweight middleware between two other projects and as an introduction to UDP network communication.*

## Description

This project implements a lightweight **UDP message relay server** using **Java** and **Maven**.

The server listens for incoming UDP datagrams, automatically registers their senders and forwards received messages to all known clients, except the original sender.

Clients are identified by their **IP address and source port**. No persistent connection is established, as communication relies entirely on UDP.

The server is intentionally kept **minimal and lightweight**, as its primary purpose is to allow independent local applications to exchange messages.

---

## Features

* UDP message relay server
* Automatic client discovery
* Message broadcasting to all known clients except the sender
* Configurable listening port (default: `5000`)
* UTF-8 message encoding
* Command-line help (`-h`, `--help`)
* Graceful shutdown handling

---

## Project Structure

```text
.
├── src/
│   └── main/
│       └── java/
│           ├── UdpServer.java
│           ├── Arguments.java
│           └── Help.java
├── exe.sh
├── pom.xml
└── README.md
```

---

## Requirements

* Java 17 or later
* Apache Maven 3.8 or later

---

## Usage

### Start the server

Run the server using the default port (`5000`):

```bash
mvn compile exec:java
```

Specify a custom listening port:

```bash
mvn compile exec:java -Dexec.args="8080"
```

### Display help

```bash
mvn compile exec:java -Dexec.args="--help"
```

### Using exe.sh

The project includes an `exe.sh` script to simplify server execution and debugging without manually typing the Maven command.

```bash
chmod +x exe.sh
./exe.sh
```

Arguments can be passed directly to the script:

```bash
./exe.sh 8080
```

The script forwards the supplied arguments to the Java application through Maven:

```bash
mvn compile exec:java -Dexec.args="$*"
```

---

## Known Limitations

* UDP does not guarantee message delivery or ordering.
* Clients are identified by their source IP address and port.
* Disconnected clients are not automatically removed.
* Incoming UDP datagrams are received using a 1024-byte buffer.
* No authentication or encryption is currently implemented.

---

## Future Improvements

* **Optional secure mode:** introduce message authentication using a shared secret provided through the `UDPSERV_KEY` environment variable.
* **Client management:** improve client handling with registration and proper client list management.

---

## Contributions

Suggestions, bug reports and contributions are welcome.

Feel free to open an issue or submit a pull request.

---
