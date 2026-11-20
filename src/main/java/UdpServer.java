import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class UdpServer {
		public static void main(String[] args)
		{
				final int				port;
				final DatagramSocket	socket;

				port = Arguments.parse(args);
				if (port == 0)
						System.exit(0);
				else if (port == -1)
						System.exit(1);
				try { socket = new DatagramSocket(port); }
				catch (IOException e)
				{
						System.err.println("udpserv: [ERROR]: " + e.getMessage());
						return;
				}
				Runtime.getRuntime().addShutdownHook(new Thread(() ->
				{
						System.out.println("\nudpserv: [INFO]: Shutting down UDP server...");
						socket.close();
				}));
				try { server_loop(port, socket); }
				catch (IOException e)
				{
						if (!socket.isClosed())
						{
								System.err.println("udpserv: [ERROR]: " + e.getMessage());
								System.exit(1);
						}
						return;
				}
		}
		
		public static void server_loop(final int port, final DatagramSocket socket) throws IOException
		{
				byte[]					recvBuffer;
				byte[]					sendBuffer;
				DatagramPacket			recvPacket;
				DatagramPacket			sendPacket;
				String					message;
				Set<InetSocketAddress>	clients;
				InetSocketAddress		new_client;

				recvBuffer = new byte[1024];
				clients = new HashSet<>();
				System.out.println("Listening on port: " + port);
				while (true) 
				{
						recvPacket = new DatagramPacket(recvBuffer, recvBuffer.length);
						socket.receive(recvPacket);
						new_client = new InetSocketAddress(
								recvPacket.getAddress(),
								recvPacket.getPort()
						);
						clients.add(new_client);
						message = new String(
								recvPacket.getData(), 
								0, 
								recvPacket.getLength(),
								StandardCharsets.UTF_8
						);
						sendBuffer = message.getBytes(StandardCharsets.UTF_8);
						for (InetSocketAddress recipient : clients)
						{
								if (!recipient.equals(new_client))
								{
										sendPacket = new DatagramPacket(
											sendBuffer,
											sendBuffer.length,
											recipient.getAddress(),
											recipient.getPort()
										);
										socket.send(sendPacket);
								}
						}
				}
		}
}
