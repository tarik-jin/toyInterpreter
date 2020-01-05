package chap13;

import chap6.Environment;
import chap7.Function;
import stone.ast.BlockStmnt;
import stone.ast.ParameterList;

public class VmFunction extends Function {
	protected int entry;
	public VmFunction(ParameterList parameters, BlockStmnt body, Environment env, int entry) {
		super(parameters, body, env);
		this.entry = entry;
	}
	public int entry() {
		return entry;
	}
}
