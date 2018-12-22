package com.clazy.trainer.unit;

import com.clazy.trainer.tools.Attribute;

public class Sex extends Attribute {

	private Sex(String _Name, char _Symbol) {
		super(_Name, _Symbol);
	}
	
	public static Sex getBySymbol(char TargetSymbol) {
		return (Sex)(Attribute.getBySymbol(TargetSymbol, Sex.class));
	}
	
	public static Sex Male = new Sex("Male", 'M');
	public static Sex Female = new Sex("Female", 'F');
	public static Sex None = new Sex("None", 'N');
}
