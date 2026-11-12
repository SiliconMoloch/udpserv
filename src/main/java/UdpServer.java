import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.io.IOException;

public class UdpServer {
		public static void main(String[] args) throws IOException {
				final int				port = Arguments.parse(args);
				final DatagramSocket	socket = new DatagramSocket(port);
				byte[]					buffer;

				buffer = new byte[1024];
				System.out.println("Listening on port: " + port);
				DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
				socket.receive(packet);
				String message = new String(packet.getData(), 0, packet.getLength());
				System.out.println("recevied message :" + message);
				socket.close();
		}
}
