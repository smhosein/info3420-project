
public class CoreParser extends Parser
{
	
	private static CoreParser cp;
	private Parser header;
	private Parser declarations;
	private Parser body;
	private Parser[] allParsers;
	
	private CoreParser()
	{
		header = HeaderParser.getInstance();
		declarations = DeclarationsParser.getInstance();
		body = BodyParser.getInstance();
		
		allParsers = new Parser[3];
		allParsers[0] = header;
		allParsers[1] = declarations;
		allParsers[2] = body;
		
	}
	
	public static CoreParser getInstance()
	{
		if (cp == null)
			cp = new CoreParser();
		return cp;
	}
	
	
	public ProdResult parse(String input)
	{
		ProdResult res = null;
		for (int i = 0; i < 3; i++)
		{
			
			res = allParsers[i].parse(input);
			if (!res.isSuccess())
			{
				return res;
			}
			input = res.getEndGroup();
		}
		return res;
	}

}
