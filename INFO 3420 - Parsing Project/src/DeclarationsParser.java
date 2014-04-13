import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Parser to handle the delarations
public class DeclarationsParser extends Parser
{
	
	private static DeclarationsParser dp;
	private String regex1 = "startDeclar(\\s)+(.*)?endDeclar(\\s)+((.*))";
	private String regex2 = "((([a-z])(([a-zA-Z]|[0-9]){0,7}\\$)(\\s)*)*)";
			
	
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
