package chap14;

import java.util.List;

import chap14.InferTypes.UnknownTypeEx;
import chap14.TypeInfo.FunctionType;
import chap14.TypeInfo.UnknownType;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;
import stone.ast.ASTree;

@Require({TypeChecker.class, InferTypes.class})
@Reviser public class InferFuncTypes {
	@Reviser public static class DefStmntEx3 extends TypeChecker.DefStmntEx2{

		public DefStmntEx3(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}

		@Override
		public TypeInfo typeCheck(TypeEnv tenv) throws TypeException {
			// TODO Auto-generated method stub
			FunctionType func = super.typeCheck(tenv).toFunctionType();
			for(TypeInfo t: func.parameterTypes) {
				fixUnknown(t);
			}
			fixUnknown(func.returnType);
			return func;
		}
		protected void fixUnknown(TypeInfo t) {
			if(t.isUnknownType()) {
				UnknownType ut = t.toUnknownType();
				if(!((UnknownTypeEx)ut).resolved()) {
					((UnknownTypeEx)ut).setType(TypeInfo.ANY);
				}
				else {
					
				}
			}
			else {
				
			}
		}
	}
}
