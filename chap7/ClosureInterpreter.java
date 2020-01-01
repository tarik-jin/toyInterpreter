package chap7;

import chap6.BasicInterpreter;
import stone.ClosureParser;
import stone.ParseException;

public class ClosureInterpreter extends BasicInterpreter {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		run(new ClosureParser(), new NestedEnv());
	}

}
