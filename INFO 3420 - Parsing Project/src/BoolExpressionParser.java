import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BoolExpressionParser extends Parser
{

	
	private static BoolExpressionParser bp;
	private String poss2 = 
			"(" + Globals.RELATIONAL_EXP +")" + "(\\s)+" + "(" + Globals.BOOL_OP + ")" + "(.*)";
	private String poss1 = 
			Globals.RELATIONAL_EXP;
	
	private BoolExpressionParser()
	{
		
	}
	
	public static BoolExpressionParser getInstance()
	{
		if(bp == null)
			bp = new BoolExpressionParser();
		return bp;
	}
	
	
	
	@Override
	public ProdResult parse(String str)
	{
		Pattern pat = Pattern.compile(poss1, Pattern.DOTALL);
		Matcher mat = pat.matcher(str);
		// If our boolean expression comprises a single relational expression
		if(mat.matches())
		{
			return (new Success(""));
		}
		
		pat = Pattern.compile(poss2, Pattern.DOTALL);
		mat = pat.matcher(str);
		
		if(!mat.matches())
		{
			return (new Failure("Bad relational expression"));
		}
		
		String ans = mat.group(25).trim();
		return BoolExpressionParser.getInstance().parse(ans);
	}
	
	

}
