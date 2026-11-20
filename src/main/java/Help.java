public class Help {
		public static int display() {
				final String	bin = "udpserv";

				System.out.println("usage: " + bin + " [PORT_NUMBER]");
				System.out.println("\tDefault port: 5000");
				System.out.println("\t-h, --help: display help");
				return (0);
		}
}
