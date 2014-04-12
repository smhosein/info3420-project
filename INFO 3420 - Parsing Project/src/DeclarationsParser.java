import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Parser to handle the delarations
public class DeclarationsParser extends Parser
{
	
	private static DeclarationsParser dp;
	private String regex1 = "startDeclar(\\s)+(.*)?endDeclar(\\s)+((.*))";
	private String regex2 = "((([a-z])(([a-zA-Z]|[1-9]){0,7}\\$)(\\s)*)*)";
			
	
	private DeclarationsParser()
	{
		
	}
	
	public static DeclarationsParser getInstance()
	{
		if (dp == null)
			dp = new DeclarationsParser();
		return dp;
	}
	
	public ProdResult parse(String str)
	{
		/*// First let us check if our declaraion
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
		
		return (new Failure("Improper declaraion block"));*/
		
		Pattern pat = Pattern.compile(regex1, Pattern.DOTALL);
		Matcher mat = pat.matcher(str);
		if (mat.matches())
		{
			Pattern pat2 = Pattern.compile(regex2, Pattern.DOTALL);
			Matcher mat2 = pat2.matcher((String)mat.group(2));
			if (mat2.matches())
			{
				return (new Success(mat.group(4).trim()));
			}
			return (new Failure("Bad declaration of varaible in  declarations block"));
		}
		return (new Failure("Improper declaraion block"));
	}

}
