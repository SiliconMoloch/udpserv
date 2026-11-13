public class Arguments {
		public static int parse(String[] args)
                {
                                if (args.length == 0)
                                        return (5000);
								else if (args.length == 1 && (args[0] == "-h" || args[0] == "--help"))
								{
										Help.display();
										return (0);
								}
								else if (args.length == 1)
								{
										try {
										final int port = Integer.parseInt(args[0]);
										return (port);
										}
										catch (Exception e)
										{
												System.err.println(e.getMessage());
												return (0);
										}
								}
								return (0);
                }
}
