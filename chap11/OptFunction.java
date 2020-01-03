package chap11;

import chap6.Environment;
import chap7.Function;
import stone.ast.BlockStmnt;
import stone.ast.ParameterList;

public class OptFunction extends Function {
	protected int size;
	public OptFunction(ParameterList parameters, BlockStmnt body,
			Environment env, int memorySize) {
		super(parameters, body, env);
		size = memorySize;
	}
	@Override
	public Environment makeEnv() {
		// TODO Auto-generated method stub
		return new ArrayEnv(size, env);
	}
	
}
