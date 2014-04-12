import java.util.regex.Pattern;


public class BodyParser extends Parser
{
	
	private static BodyParser bp;
	private AssignmentParser ap;
	
	
	// Strings to represent the compatible formats of statements 
	
	private String assignment = 
			Globals.VARIABLE + "$";
	
	
	
	private BodyParser()
	{
		ap = AssignmentParser.getInstance();
		
	}
	
	public static BodyParser getInstance()
	{
		if(bp == null)
			bp = new BodyParser();
		return bp;
	}
	

	@Override
	public ProdResult parse(String str)
	{
		ProdResult res = ap.parse(str);
		if(res.isSuccess())
		{
			String ans = res.getEndGroup().trim();
			if(ans.isEmpty())
				return (new Success("Success"));
			else
			{
				return this.parse(ans);
			}
		}
		
		return (new Failure("Error in parsing statements in body"));
	}

}
