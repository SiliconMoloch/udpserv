import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;

public class UdpServer {
		public static void main(String[] args) throws IOException {
				final int				port = Arguments.parse(args);
				final DatagramSocket	socket = new DatagramSocket(port);

				byte[]					recvBuffer;
				DatagramPacket			recvPacket;
				byte[]					sendBuffer;
				DatagramPacket			sendPacket;
				final String			successResponse = "msg received!";
				String					message;

				recvBuffer = new byte[1024];
				System.out.println("Listening on port: " + port);
				while (true) {
					recvPacket = new DatagramPacket(recvBuffer, recvBuffer.length);
					socket.receive(recvPacket);
					message = new String(recvPacket.getData(), 0, recvPacket.getLength());
					if (message == "quit")
							break;
				System.out.println("recevied message :" + message);
					sendBuffer = successResponse.getBytes();
					sendPacket = new DatagramPacket(
							sendBuffer,
							sendBuffer.length,
							recvPacket.getAddress(),
							recvPacket.getPort()
							);
					socket.send(sendPacket);
				}
				socket.close();
		}
}
