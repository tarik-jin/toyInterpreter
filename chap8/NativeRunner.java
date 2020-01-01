package chap8;

import chap7.ClosureEvaluator;
import javassist.gluonj.util.Loader;

public class NativeRunner {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Loader.run(NativeInterpreter.class, args, NativeEvaluator.class, ClosureEvaluator.class);
	}
}
