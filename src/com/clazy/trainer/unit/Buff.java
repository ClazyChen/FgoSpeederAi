package com.clazy.trainer.unit;

import com.clazy.trainer.tools.AttributeDisplay;

public class Buff extends AttributeDisplay {
	private BuffType type;
	public double value;
	public int RemainTimes;
	public int RemainTurns;
	public BuffType getType() {
		return type;
	}
	public void setType(BuffType type) {
		this.type = type;
	}
	
	public Buff(BuffType _type, double _value, int _RemainTimes, int _RemainTurns) {
		setType(_type);
		value = _value;
		RemainTimes = _RemainTimes;
		RemainTurns = _RemainTurns;
	}
}
