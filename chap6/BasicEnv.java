package chap6;

import java.util.HashMap;

public class BasicEnv implements Environment {
	
	protected HashMap<String, Object> values;
	

	public BasicEnv() {
		values = new HashMap<String, Object>();
	}

	@Override
	public void put(String name, Object value) {
		// TODO Auto-generated method stub
		values.put(name, value);
	}

	@Override
	public Object get(String name) {
		// TODO Auto-generated method stub
		return values.get(name);
	}

}
