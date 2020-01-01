package chap7;

import java.util.List;

import chap6.Environment;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;
import stone.ast.ASTree;
import stone.ast.Fun;

@Require (FuncEvaluator.class)
@Reviser public class ClosureEvaluator {

	@Reviser public static class FunEx extends Fun{

		public FunEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}
		public Object eval(Environment env) {
			return new Function(parameters(), body(), env);
		}
	}


}
