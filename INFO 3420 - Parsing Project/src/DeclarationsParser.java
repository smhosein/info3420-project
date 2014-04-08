import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Parser to handle the delarations
public class DeclarationsParser extends Parser
{
	
	private static DeclarationsParser dp;
	private String regex1 = 
			"startDecalr(\\s)+(.*)+endDecalr(.*)+";
	private String regex2 = 
			"([a-z])([a-zA-Z]|[1-9])+";
	private String regex3 = 
			"((" + regex2 + ")(\\s)+)+";
			
	
	private DeclarationsParser()
	{
		
	}
	
	public static DeclarationsParser getInstance()
	{
		if (dp == null)
			dp = new DeclarationsParser();
		return dp;
	}
	
	public ProdResult parse(String input)
	{
		// First let us check if our declaraion
		// block is properly formated in the first place
		
		Pattern pat = Pattern.compile(regex1);
		Matcher mat = pat.matcher(input);
		
		// If our declaration block is a match
		if (pat.matches(regex1, input))
		{
			String toCheck = mat.group(1);
			String end = mat.group(3);
			if (Pattern.matches(regex3, toCheck))
			{
				return (new Success(end));
			}
			
			return (new Failure("Bad declarations in declarations block"));
		}
		
		return (new Failure("Improper declaraion block"));
	}

}
