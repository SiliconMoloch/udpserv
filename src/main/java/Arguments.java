public class Arguments {
		public static int parse(String[] args)
                {
                                if (args.length == 0)
                                        return (5000);
                                else if (args.length == 1)
                                        return (Integer.parseInt(args[0]));
								else
								{
										Help.display();
										return (0);
								}
                }
}
