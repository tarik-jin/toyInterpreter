package chap9;

import java.util.List;

import chap6.BasicEvaluator;
import chap6.BasicEvaluator.ASTreeEx;
import chap6.Environment;
import chap7.FuncEvaluator;
import chap7.FuncEvaluator.EnvEx;
import chap7.FuncEvaluator.PrimaryEx;
import chap7.NestedEnv;
import chap9.StoneObject.AccessException;
import javassist.gluonj.Require;
import javassist.gluonj.Reviser;
import stone.StoneException;
import stone.ast.ASTree;
import stone.ast.ClassBody;
import stone.ast.ClassStmnt;
import stone.ast.Dot;
import stone.ast.PrimaryExpr;

@Require(FuncEvaluator.class)
@Reviser public class ClassEvaluator {
	@Reviser public static class ClassStmntEx extends ClassStmnt {

		public ClassStmntEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}
		public Object eval(Environment env) {
			ClassInfo ci = new ClassInfo(this, env);
			((EnvEx)env).put(name(), ci);
			return name();
		}
	}
	@Reviser public static class ClassBodyEx extends ClassBody{

		public ClassBodyEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}
		public Object eval(Environment env) {
			for(ASTree t: this) {
				((ASTreeEx)t).eval(env);
			}
			return null;
		}
	}
	@Reviser public static class DotEx extends Dot {

		public DotEx(List<ASTree> list) {
			super(list);
			// TODO Auto-generated constructor stub
		}
		public Object eval(Environment env, Object value) {
			String member = name();
			if(value instanceof ClassInfo) {
				if("new".equals(member)) {
					ClassInfo ci = (ClassInfo)value;
					NestedEnv e = new NestedEnv(ci.environment());
					StoneObject so = new StoneObject(e);
					e.putNew("this", so);
					initObject(ci, e);
					return so;					
				}
				else {
					//we only support Class.new
				}
			}
			else if(value instanceof StoneObject) {
				try {
					return ((StoneObject)value).read(member);
				}
				catch(AccessException e){
					
				}
			}
			else {
				
			}
			throw new StoneException("bad member access: " + member, this);
		}
		public void initObject(ClassInfo ci, Environment env) {
			if(ci.superClass() != null) {
				initObject(ci.superClass(), env);
			}
			else {
				//no superClass
			}
			((ClassBodyEx)ci.body()).eval(env);
		}
	}
	@Reviser public static class AssignEx extends BasicEvaluator.BinaryEx{

		public AssignEx(List<ASTree> c) {
			super(c);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected Object computeAssign(Environment env, Object rvalue) {
			// TODO Auto-generated method stub
			ASTree le = left();
			if(le instanceof PrimaryExpr) {
				PrimaryEx p = (PrimaryEx)le;
				if(p.hasPostfix(0) && p.postfix(0) instanceof Dot) {
					Object t = ((PrimaryEx)le).evalSubExpr(env, 1);
					if(t instanceof StoneObject) {
						return setField((StoneObject)t, (Dot)p.postfix(0), rvalue);
					}
				}
				else {
					
				}
			}
			else {
				
			}
			return super.computeAssign(env, rvalue);
		}
		protected Object setField(StoneObject obj, Dot expr, Object rvalue) {
			String name = expr.name();
			try {
				obj.write(name, rvalue);
				return rvalue;
			}
			catch(AccessException e) {
				throw new StoneException("bad member access " + location() + ": " + name);
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
