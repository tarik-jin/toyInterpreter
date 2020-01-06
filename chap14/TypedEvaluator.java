package chap14;

import java.util.List;

import chap11.EnvOptimizer;
import chap11.EnvOptimizer.ASTreeOptEx;
import chap11.Symbols;
import chap6.BasicEvaluator.ASTreeEx;
import chap6.Environment;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;
import stone.ast.ASTLeaf;
import stone.ast.ASTree;
import stone.ast.BlockStmnt;
import stone.ast.TypeTag;
import stone.ast.VarStmnt;

@Require(EnvOptimizer.class)
@Reviser public class TypedEvaluator {
	@Reviser public static class DefStmntEx extends EnvOptimizer.DefStmntEx{

		public DefStmntEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}
		public TypeTag type() {
			return (TypeTag)child(2);
		}
		@Override
		public BlockStmnt body() {
			// TODO Auto-generated method stub
			return (BlockStmnt)child(3);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(def " + name() + " " + parameters() + " " + type() + " "
					+ body() + ")";
		}
	}
	@Reviser public static class ParamListEx extends EnvOptimizer.ParamsEx{

		public ParamListEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String name(int i) {
			// TODO Auto-generated method stub
			return ((ASTLeaf)child(i).child(0)).token().getText();
		}
		public TypeTag typeTag(int i) {
			return (TypeTag)child(i).child(1);
		}
	}
	@Reviser public static class VarStmnEx extends VarStmnt{
		protected int index;

		public VarStmnEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}
		public void lookup(Symbols syms) {
			index = syms.putNew(name());
			((ASTreeOptEx)initializer()).lookup(syms);
		}
		public Object eval(Environment env) {
			Object value = ((ASTreeEx)initializer()).eval(env);
			((EnvOptimizer.EnvEx2)env).put(0, index, value);
			return value;
		}
	}

	
	
	
	
	
	
	
	
	
	
	
}
