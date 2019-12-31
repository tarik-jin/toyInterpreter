package chap6;

import javassist.gluonj.util.Loader;

public class Runner {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Loader.run(BasicInterpreter.class, args, BasicEvaluator.class);
	}

}
