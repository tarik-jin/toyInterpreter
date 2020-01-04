package chap12;

import chap11.EnvOptInterpreter;
import chap11.ResizableArrayEnv;
import chap8.Natives;
import stone.ClassParser;
import stone.ParseException;

public class ObjOptInterpreter extends EnvOptInterpreter{

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		run(new ClassParser(), new Natives().environment(new ResizableArrayEnv()));
	}

}
