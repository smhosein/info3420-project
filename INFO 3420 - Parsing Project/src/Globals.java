
public class Globals 
{
	
	public final static String VARIABLE = "([a-z](([a-zA-Z]|[0-9]){0,7}))";
	public final static String OP = "(+|-|*|\\)";
	public final static String RELATIONAL_OP = "(<|>)";
	public final static String BOOL_OP = "(@|^)";
	public final static String DIGIT = "([0-9])";
	public final static String NUM = DIGIT + "+";
	public final static String POST_CALC = "(" + NUM + "|" + VARIABLE + ")";
	public final static String POSTFIX = 
			"(" + POST_CALC + "(\\s)+" + POST_CALC + ")+";
	public final static String CALCULABLE = 
			"(" + POSTFIX + "|" + NUM + "|" + VARIABLE + ")";
	public final static String RELATIONAL_EXP = 
			"((" + CALCULABLE + ")" + RELATIONAL_OP + "(" + CALCULABLE + "))";
	// Cannot represent the boolean expressions as regex
	// So parse the boolean expressions, we need repeatedly split by
	// BOOL_OP and parse each partial 
	
	
	

}
