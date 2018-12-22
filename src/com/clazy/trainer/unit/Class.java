package com.clazy.trainer.unit;

import com.clazy.trainer.tools.Attribute;

public class Class extends Attribute {
	public double ClassCoefficient;

	private Class(String _Name, char _Symbol, double _ClassCoefficient) {
		super(_Name, _Symbol);
		ClassCoefficient = _ClassCoefficient;
	}
	
	public static Class getBySymbol(char TargetSymbol) {
		return (Class)(Attribute.getBySymbol(TargetSymbol, Class.class));
	}
	
	/**
	 * 
	 * @param TargetClass
	 * @return 对目标职阶的职阶克制系数，默认值1.0
	 */
	public double ClassSuperiorityCoeffientOver(Class TargetClass) {
		switch (Symbol) {
		case 'S':
			switch (TargetClass.Symbol) {
			case 'L': case 'B': return 2.0; 
			case 'A': case 'U': return 0.5;
			default: return 1.0;
			}
		case 'L':
			switch (TargetClass.Symbol) {
			case 'A': case 'B': return 2.0; 
			case 'S': case 'U': return 0.5;
			default: return 1.0;
			}
		case 'A':
			switch (TargetClass.Symbol) {
			case 'S': case 'B': return 2.0; 
			case 'L': case 'U': return 0.5;
			default: return 1.0;
			}
		case 'R':
			switch (TargetClass.Symbol) {
			case 'C': case 'B': case (char)1: return 2.0; 
			case 'N': case 'U': return 0.5;
			default: return 1.0;
			}
		case 'C':
			switch (TargetClass.Symbol) {
			case 'N': case 'B': case (char)1: return 2.0; 
			case 'R': case 'U': return 0.5;
			default: return 1.0;
			}
		case 'N':
			switch (TargetClass.Symbol) {
			case 'R': case 'B': case (char)1: return 2.0; 
			case 'C': case 'U': return 0.5;
			default: return 1.0;
			}
		case 'B':
			switch (TargetClass.Symbol) {
			case 'H': case (char)2: case (char)3: return 1.0; 
			case 'F': return 0.5;
			default: return 1.5;
			}
		case 'U':
			switch (TargetClass.Symbol) {
			case 'M': case 'B': return 2.0; 
			case 'V': return 0.5;
			default: return 1.0;
			}
		case 'V':
			switch (TargetClass.Symbol) {
			case 'U': case 'B': return 2.0; 
			case 'M': return 0.5;
			default: return 1.0;
			}
		case 'M':
			switch (TargetClass.Symbol) {
			case 'V': case 'B': return 2.0; 
			case 'U': return 0.5;
			case (char)3: return 1.2;
			default: return 1.0;
			}
		case 'O':
			switch (TargetClass.Symbol) {
			case 'V': case 'F': return 2.0; 
			case 'S': case 'A': case 'L': return 0.5;
			case 'R': case 'C': case 'N': return 1.5;
			case (char)3: return 1.2;
			default: return 1.0;
			}
		case 'F':
			switch (TargetClass.Symbol) {
			case 'F': case 'B': return 2.0; 
			case 'O': return 0.5;
			default: return 1.0;
			}
		case (char)1:
			switch (TargetClass.Symbol) {
			case 'S': case 'A': case 'L': case 'B': return 2.0; 
			case 'V': return 0.5;
			default: return 1.0;
			}
		default:
			return 1.0;
		}
	}
	
	public static Class Saber = new Class("Saber", 'S', 1.0);
	public static Class Lancer = new Class("Lancer", 'L', 1.05);
	public static Class Archer = new Class("Archer", 'A', 0.95);
	public static Class Rider = new Class("Rider", 'R', 1.0);
	public static Class Caster = new Class("Caster", 'C', 0.9);
	public static Class Assassin = new Class("Assassin", 'N', 0.9);
	public static Class Berserker = new Class("Berserker", 'B', 1.1);
	public static Class Ruler = new Class("Ruler", 'U', 1.1);
	public static Class Avenger = new Class("Avenger", 'V', 1.1);
	public static Class MoonCancer = new Class("MoonCancer", 'M', 1.0);
	public static Class Alterego = new Class("Alterego", 'O', 1.0);
	public static Class Foreigner = new Class("Foreigner", 'F', 1.0);
	public static Class Shielder = new Class("Shielder", 'H', 1.0);
	public static Class BeastI = new Class("BeastI", (char)1, 1.0);
	public static Class BeastII = new Class("BeastII", (char)2, 1.0);
	public static Class BeastIII = new Class("BeastIII", (char)3, 1.0);
}
