package chap14;

import chap8.NativeEvaluator;
import javassist.gluonj.util.Loader;

public class JavaRunner {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Loader.run(TypedInterpreter.class, args, ToJava.class,
				InferFuncTypes.class, NativeEvaluator.class);
	}

}
