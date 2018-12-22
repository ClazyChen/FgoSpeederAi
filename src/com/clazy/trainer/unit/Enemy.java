package com.clazy.trainer.unit;

public class Enemy extends Unit implements Cloneable {
	public Enemy() {
		super();
	}
	
	public Enemy clone() {
		try {
			return (Enemy) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
