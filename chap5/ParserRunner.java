package chap5;

import stone.BasicParser;
import stone.CodeDialog;
import stone.Lexer;
import stone.ParseException;
import stone.Token;
import stone.ast.ASTree;

public class ParserRunner {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Lexer l = new Lexer(new CodeDialog());
		BasicParser bp = new BasicParser();
		while(l.peek(0) != Token.EOF) {
			ASTree ast = bp.parse(l);
			System.out.println("=> " + ast.toString());
		}
	}

}
