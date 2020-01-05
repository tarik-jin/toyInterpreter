package chap13;

import chap11.ResizableArrayEnv;

public class StoneVMEnv extends ResizableArrayEnv implements HeapMemory {
	protected StoneVM svm;
	protected Code code;
	public StoneVMEnv(int codeSize, int stackSize, int stringsSize) {
		// TODO Auto-generated constructor stub
		svm = new StoneVM(codeSize, stackSize, stringsSize, this);
		code = new Code(svm);
	}
	public StoneVM stoneVM() {
		return svm;
	}
	public Code code() {
		return code;
	}

	@Override
	public Object read(int index) {
		// TODO Auto-generated method stub
		return values[index];
	}

	@Override
	public void write(int index, Object v) {
		// TODO Auto-generated method stub
		values[index] = v;
	}

}
