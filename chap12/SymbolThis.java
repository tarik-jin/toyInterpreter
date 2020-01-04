package chap12;

import chap11.Symbols;
import stone.StoneException;

public class SymbolThis extends Symbols {
	public static final String NAME = "this";
	public SymbolThis(Symbols outer) {
		super(outer);
		add(NAME);
	}
	@Override
	public int putNew(String key) {
		// TODO Auto-generated method stub
		throw new StoneException("fatal");
	}
	@Override
	public Location put(String key) {
		// TODO Auto-generated method stub
		Location loc = outer.put(key);
		if(loc.nest >= 0) {
			loc.nest++;
		}
		else {
			//???
		}
		return loc;
	}
	
	
}
