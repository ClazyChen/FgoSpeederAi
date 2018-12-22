package com.clazy.trainer.unit;

public class Servant extends Unit implements Cloneable {
	public Servant() {
		super();
	}
	
	public Servant clone() {
		try {
			return (Servant) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
