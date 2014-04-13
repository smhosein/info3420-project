import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Parser to handle the displaying
public class DisplayParser extends Parser
{
	private String var = "(([a-z])(([a-zA-Z]|[1-9]){0,7}))";//\"[^\"]+?\" 
	private static DisplayParser dp;
	private String regex0 = "display\\{((.*))}\\$";
	private String regex1 = "(([a-z])(([a-zA-Z]|[1-9]){0,7}))";
	private String regex2 = "(\"(.*)?\")";
	private String regex3 = "(([a-z])(([a-zA-Z]|[1-9]){0,7})\\-(\"(.*)?\"))";
	private String regex4 = "((\"(.*)?\")\\-([a-z])(([a-zA-Z]|[1-9]){0,7}))";
	private String regex5 = "^(\"[^\"]+?\"\\-[([a-z])(([a-zA-Z]|[1-9]){0,7})]\\-)+\"[^\"]+?\"$";
	private String regex6 = "^(\"[^\"]+?\"\\-[([a-z])(([a-zA-Z]|[1-9]){0,7})]\\-)+\"[^\"]+?\"(\\-(([a-z])(([a-zA-Z]|[1-9]){0,7})))*$";
	private String regex7 = "^((([a-z])(([a-zA-Z]|[1-9]){0,7}))\\-\"[^\"]+?\"\\-)+(([a-z])(([a-zA-Z]|[1-9]){0,7}))$";
	private String regex8 = "^((([a-z])(([a-zA-Z]|[1-9]){0,7}))\\-\"[^\"]+?\"\\-)+(([a-z])(([a-zA-Z]|[1-9]){0,7}))(\\-\"[^\"]+?\")$";
	
	
	private DisplayParser()
	{
		
	}
	
	public static DisplayParser getInstance()
	{
		if (dp == null)
			dp = new DisplayParser();
		return dp;
	}
	
	public ProdResult parse(String str)
	{
		//System.out.println(str);
		Pattern pat0 = Pattern.compile(regex0, Pattern.DOTALL);
		Matcher mat0 = pat0.matcher(str);
		if (mat0.matches())
		{
			str = (String)mat0.group(1);
			Pattern pat1 = Pattern.compile(regex1, Pattern.DOTALL);
			Pattern pat2 = Pattern.compile(regex2, Pattern.DOTALL);
			Pattern pat3 = Pattern.compile(regex3, Pattern.DOTALL);
			Pattern pat4 = Pattern.compile(regex4, Pattern.DOTALL);
			Pattern pat5 = Pattern.compile(regex5, Pattern.DOTALL);
			Pattern pat6 = Pattern.compile(regex6, Pattern.DOTALL);
			Pattern pat7 = Pattern.compile(regex7, Pattern.DOTALL);
			Pattern pat8 = Pattern.compile(regex8, Pattern.DOTALL);
			Matcher mat1 = pat1.matcher(str);
			Matcher mat2 = pat2.matcher(str);
			Matcher mat3 = pat3.matcher(str);
			Matcher mat4 = pat4.matcher(str);
			Matcher mat5 = pat5.matcher(str);
			Matcher mat6 = pat6.matcher(str);
			Matcher mat7 = pat7.matcher(str);
			Matcher mat8 = pat8.matcher(str);
			
			if (mat1.matches()||mat2.matches()||mat3.matches()||mat4.matches()||mat5.matches()||mat6.matches()||mat7.matches()||mat8.matches())
			{
				return (new Success("Sucess"));
			}
		}
		return (new Failure("Improper display block"));
		
	}

}
