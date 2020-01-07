package chap14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import chap14.TypeInfo.UnknownType;
import javassist.gluonj.Reviser;
import stone.ast.ASTree;

@Reviser public class InferTypes {
	@Reviser public static class TypeInfoEx extends TypeInfo{

		@Override
		public void assertSubtypeOf(TypeInfo type, TypeEnv env, ASTree where) 
				throws TypeException {
			// TODO Auto-generated method stub
			if(type.isUnknownType()) {
				((UnknownTypeEx)type.toUnknownType()).assertSupertypeOf(this, env, where);
			}
			else {
				super.assertSubtypeOf(type, env, where);
			}
		}

		@Override
		public TypeInfo union(TypeInfo right, TypeEnv tenv) {
			// TODO Auto-generated method stub
			if(right.isUnknownType()) {
				return right.union(this, tenv);
			}
			else {
				return super.union(right, tenv);
			}
		}

		@Override
		public TypeInfo plus(TypeInfo right, TypeEnv tenv) {
			// TODO Auto-generated method stub
			if(right.isUnknownType()) {
				return right.plus(this, tenv);
			}
			else {
				return super.plus(right, tenv);
			}
		}
	}
	@Reviser public static class UnknownTypeEx extends TypeInfo.UnknownType{
		protected TypeInfo type = null;
		public boolean resolved() {
			return type != null;
		}
		public void setType(TypeInfo t) {
			type = t;
		}
		@Override
		public TypeInfo type() {
			// TODO Auto-generated method stub
			return type == null ? ANY : type;
		}
		@Override
		public void assertSubtypeOf(TypeInfo type, TypeEnv env, ASTree where) 
				throws TypeException {
			// TODO Auto-generated method stub
			if(resolved()) {
				type.assertSubtypeOf(type, env, where);
			}
			else {
				((TypeEnvEx)env).addEquation(this, type);
			}
		}
		public void assertSupertypeOf(TypeInfo t, TypeEnv tenv, ASTree where) 
				throws TypeException{
			if(resolved()) {
				t.assertSubtypeOf(type, tenv, where);
			}
			else {
				((TypeEnvEx)tenv).addEquation(this, t);
			}
		}
		@Override
		public TypeInfo union(TypeInfo right, TypeEnv tenv) {
			// TODO Auto-generated method stub
			if(resolved()) {
				return type.union(right, tenv);
			}
			else {
				((TypeEnvEx)tenv).addEquation(this, right);
				return right;
			}
		}
		@Override
		public TypeInfo plus(TypeInfo right, TypeEnv tenv) {
			// TODO Auto-generated method stub
			if(resolved()) {
				return type.plus(right, tenv);
			}
			else {
				((TypeEnvEx)tenv).addEquation(this, INT);
				return right.plus(INT, tenv);
			}
		}
	}
	@Reviser public static class TypeEnvEx extends TypeEnv{
		public static class Equation extends ArrayList<UnknownType>{}
		protected List<Equation> equations = new LinkedList<Equation>();
		public void addEquation(UnknownType t1, TypeInfo t2) {
			if(t2.isUnknownType()) {
				if(((UnknownTypeEx)t2.toUnknownType()).resolved()) {
					t2 = t2.type();
				}
				else {
					
				}
			}
			else {
				
			}
			Equation eq = find(t1);
			if(t2.isUnknownType()) {
				eq.add(t2.toUnknownType());
			}
			else {
				for(UnknownType t: eq) {
					((UnknownTypeEx)t).setType(t2);
				}
				equations.remove(eq);
			}
		}
		protected Equation find(UnknownType t) {
			for(Equation e: equations) {
				if(e.contains(t)) {
					return e;
				}
				else {
					//continue
				}
			}
			Equation e = new Equation();
			e.add(t);
			equations.add(e);
			return e;
		}
	}

}

