package com.clazy.trainer.unit;

import com.clazy.trainer.tools.Attribute;

public class HiddenClass extends Attribute {
	private HiddenClass(String _Name, char _Symbol) {
		super(_Name, _Symbol);
	}
	
	public static HiddenClass getBySymbol(char TargetSymbol) {
		return (HiddenClass)(Attribute.getBySymbol(TargetSymbol, HiddenClass.class));
	}
	
	/**
	 * 
	 * @param TargetHiddenClass
	 * @return 隐藏属性克制系数
	 */
	public double HiddenClassSuperiorityCoefficientOver(HiddenClass TargetHiddenClass) {
		switch (Symbol) {
		case 'S':
			switch (TargetHiddenClass.Symbol) {
			case 'E': return 1.1;
			case 'M': return 0.9;
			default: return 1.0;
			}
		case 'E':
			switch (TargetHiddenClass.Symbol) {
			case 'M': return 1.1;
			case 'S': return 0.9;
			default: return 1.0;
			}
		case 'M':
			switch (TargetHiddenClass.Symbol) {
			case 'S': return 1.1;
			case 'E': return 0.9;
			default: return 1.0;
			}
		case 'X':
			switch (TargetHiddenClass.Symbol) {
			case 'B': return 1.1;
			default: return 1.0;
			}
		case 'B':
			switch (TargetHiddenClass.Symbol) {
			case 'X': return 1.1;
			default: return 1.0;
			}
		default:
			return 1.0;
		}
	}
	
	public static HiddenClass Sky = new HiddenClass("Sky", 'S');
	public static HiddenClass Earth = new HiddenClass("Earth", 'E');
	public static HiddenClass Man = new HiddenClass("Man", 'M');
	public static HiddenClass Star = new HiddenClass("Star", 'X');
	public static HiddenClass Beast = new HiddenClass("Beast", 'B');
}
