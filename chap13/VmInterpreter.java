package chap13;

import chap11.EnvOptInterpreter;
import chap8.Natives;
import stone.FuncParser;
import stone.ParseException;

public class VmInterpreter extends EnvOptInterpreter {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		run(new FuncParser(), new Natives().environment(
				new StoneVMEnv(100000, 100000, 1000)));
	}

}
