package chap11;

import java.util.Arrays;

import chap11.EnvOptimizer.EnvEx2;
import chap6.Environment;

public class ResizableArrayEnv extends ArrayEnv {
	protected Symbols names;
	public ResizableArrayEnv() {
		super(10, null);
		names = new Symbols();
	}
	@Override
	public Symbols symbols() {
		// TODO Auto-generated method stub
		return names;
	}
	@Override
	public Object get(String name) {
		// TODO Auto-generated method stub
		Integer i = names.find(name);
		if(i == null) {
			if(outer == null) {
				return null;
			}
			else {
				return outer.get(name);
			}
		}
		else {
			return values[i];
		}
	}
	@Override
	public void put(String name, Object value) {
		// TODO Auto-generated method stub
		Environment e = where(name);
		if(e == null) {
			e = this;
		}
		else {
			
		}
		((EnvEx2)e).putNew(name, value);
	}
	@Override
	public void putNew(String name, Object value) {
		// TODO Auto-generated method stub
		assign(names.putNew(name), value);
	}
	@Override
	public Environment where(String name) {
		// TODO Auto-generated method stub
		if(names.find(name) != null) {
			return this;
		}
		else if(outer == null) {
			return null;
		}
		else {
			return ((EnvEx2)outer).where(name);
		}
	}
	@Override
	public void put(int nest, int index, Object value) {
		// TODO Auto-generated method stub
		if(nest == 0) {
			assign(index, value);
		}
		else {
			super.put(nest, index, value);
		}
	}
	protected void assign(int index, Object value) {
		if(index >= values.length) {
			int newLen = values.length * 2;
			if(index >= newLen) {
				newLen = index + 1;
			}
			else {
				
			}
			values = Arrays.copyOf(values, newLen);
		}
		else {
			
		}
		values[index] = value;
	}
}
