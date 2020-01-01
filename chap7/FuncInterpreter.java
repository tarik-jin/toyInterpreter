package chap7;

import chap6.BasicInterpreter;
import stone.FuncParser;
import stone.ParseException;

public class FuncInterpreter extends BasicInterpreter {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		run(new FuncParser(), new NestedEnv());
	}

}
