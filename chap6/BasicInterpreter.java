package chap6;

import stone.BasicParser;
import stone.CodeDialog;
import stone.Lexer;
import stone.ParseException;
import stone.Token;
import stone.ast.ASTree;
import stone.ast.NullStmnt;

public class BasicInterpreter {
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		run(new BasicParser(), new BasicEnv());
	}
	public static void run(BasicParser bp, Environment env) throws ParseException{
		Lexer lexer = new Lexer(new CodeDialog());
		while(lexer.peek(0) != Token.EOF) {
			ASTree t = bp.parse(lexer);
			if(!(t instanceof NullStmnt)) {
				Object r = ((BasicEvaluator.ASTreeEx)t).eval(env);
				System.out.println("=> " + r);
			}
			else {
				//skip null statement
			}
		}
	}

}
