package chap7;

import java.util.HashMap;

import chap6.Environment;
import chap7.FuncEvaluator.EnvEx;

public class NestedEnv implements Environment {
	protected HashMap<String, Object> values;
	protected Environment outer;

	public NestedEnv() {
		// TODO Auto-generated constructor stub
		this(null);
	}
	
	public NestedEnv(Environment e) {
		values = new HashMap<String, Object>();
		outer = e;
	}
	
	public void setOuter(Environment e) {
		outer = e;
	}

	@Override
	public Object get(String name) {
		// TODO Auto-generated method stub
		Object v = values.get(name);
		if(v == null && outer != null) {
			return outer.get(name);
		}
		else {
			return v;
		}
	}
	
	public void putNew(String name, Object value) {
		values.put(name, value);
	}
	
	@Override
	public void put(String name, Object value) {
		// TODO Auto-generated method stub
		Environment e = where(name);
		if(e == null) {
			e = this;
		}
		else {
			//e is not null
		}
		((EnvEx)e).putNew(name, value);
	}
	
	public Environment where(String name) {
		if(values.get(name) != null) {
			return this;
		}
		else if (outer == null){
			return null;
		}
		else {
			return ((EnvEx)outer).where(name);
		}
	}

}
