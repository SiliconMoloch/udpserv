public class Arguments {
		public static int parse(String[] args)
                {
                                if (args.length == 0)
                                        return (5000);
								else if (args.length == 1)
								{
										if (args[0].equals("-h") || args[0].equals("--help"))
												return (Help.display());
										else
										{
												try
												{
														final int port = Integer.parseInt(args[0]);
														if (port < 1 || port > 65535)
														{
																System.err.print("udpserv: ");
																System.err.print("[ERROR]: ");
																System.err.println("Port must be between 1 and 65535");
																return (-1);
														}
														return (port);
												}
												catch (NumberFormatException e)
												{
														System.err.print("udpserv: [ERROR]: ");
														System.err.println(e.getMessage());
														return (-1);
												}
										}
								}
								System.err.println("udpserv: [ERROR]: Argument list too long");
								Help.display();
								return (-1);
				}
}
