public class Help {
		public static void display() {
				final String[] options = {
						"-h , --help: display help"};
				
				for (int i = 0; i < options.length; ++i) 
						System.out.println(options[i]);
		}
}
