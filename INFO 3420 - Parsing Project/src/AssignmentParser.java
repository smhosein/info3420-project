import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AssignmentParser extends Parser
{
	
	private static AssignmentParser ap;
	private String assignment = 
			"set"+"(\\s)+"+Globals.VARIABLE+"(\\s)+to(\\s)+"+
					Globals.CALCULABLE+"(\\$)(.*)";
//	private String assignemnt = 
//			"set(\\s)+" + Globals.VARIABLE; 
//			"(\\s)+to(\\s)+" + Globals.NUM + "$(.*)";
	
	private AssignmentParser()
	{
		
	}
	
	public static AssignmentParser getInstance()
	{
		if(ap == null)
			ap = new AssignmentParser();
		return ap;
	}
	
	

	@Override
	public ProdResult parse(String str)
	{
		Pattern pat = Pattern.compile(assignment, Pattern.DOTALL);
		Matcher mat = pat.matcher(str);
		if(!mat.matches())
		{
			return (new Failure("Bad assignment statement"));
		}
		
		//for (int i = 1; i <= mat.groupCount(); i++)
			//System.out.println(i + " : " +mat.group(i));
		
		String ans = mat.group(25).trim();
		return (new Success(ans));
		
	}
	

}
