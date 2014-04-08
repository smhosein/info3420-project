import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Parses the header 
public class HeaderParser extends Parser
{

	private static HeaderParser hp;
	private String headerRegex = 
			"prog:(\\s)+([a-zA-Z]+(\\n))(.*)endProg";
	
	
	
	private HeaderParser()
	{
		
	}
	
	public static HeaderParser getInstance()
	{
		if (hp == null)
			hp = new HeaderParser();
		return hp;
	}
	
	
	
	@Override
	public ProdResult parse(String str)
	{
		Pattern pat = Pattern.compile(headerRegex, Pattern.DOTALL);
		Matcher mat = pat.matcher(str);
		if (mat.matches())
		{
			//for (int i = 0; i < mat.groupCount(); i++)
				//System.out.println(i + " : " + mat.group(i));
			
			return (new Success(mat.group(4).trim()));
		}
		return (new Failure("Error in parsing header of programme"));
		
	}
	
	

}
