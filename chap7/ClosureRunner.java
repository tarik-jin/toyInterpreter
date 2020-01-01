package chap7;

import javassist.gluonj.util.Loader;

public class ClosureRunner {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Loader.run(ClosureInterpreter.class, args, ClosureEvaluator.class);
	}

}
