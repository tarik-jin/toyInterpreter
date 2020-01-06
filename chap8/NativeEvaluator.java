package chap8;

import java.util.List;

import chap6.BasicEvaluator.ASTreeEx;
import chap6.Environment;
import chap7.FuncEvaluator;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;
import stone.StoneException;
import stone.ast.ASTree;

@Require(FuncEvaluator.class)
@Reviser public class NativeEvaluator {
	@Reviser public static class NativeArgEx extends FuncEvaluator.ArgumentsEx{

		public NativeArgEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}
		@Override public Object eval(Environment callerEnv, Object value) {
			if(!(value instanceof NativeFunction)) {
				return super.eval(callerEnv, value);
			}
			else {
				NativeFunction func = (NativeFunction)value;
				int nparams = func.numOfParameters();
				if(size() != nparams) {
					throw new StoneException("bad number of arguments", this);
				}
				else {
					Object[] args = new Object[nparams];
					int num = 0;
					for(ASTree a: this) {
						ASTreeEx ae = (ASTreeEx)a;
						args[num++] = ae.eval(callerEnv);
					}
					return func.invoke(args, this);					
				}
			}
		}
	}
}
