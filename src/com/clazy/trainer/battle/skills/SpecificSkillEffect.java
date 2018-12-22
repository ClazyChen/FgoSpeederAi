package com.clazy.trainer.battle.skills;

import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.tools.LeveledType;
import com.clazy.trainer.tools.LeveledValue;
import com.clazy.trainer.tools.SkillEffect;
import com.clazy.trainer.unit.Unit;

/**
 * �������һ���ر�ļ���Ч���Ļ���
 * ����Ч����Ϊ1~10�����ȣ��ᱻValueӰ��
 * @author Clazy
 *
 */
public abstract class SpecificSkillEffect implements SkillEffect {
	protected LeveledValue value;
	private int Level;
	protected int LastTimes;
	protected int LastTurns;
	
	public SpecificSkillEffect(double LowerValue, double UpperValue, String LastTime) {
		value = new LeveledValue(LowerValue, UpperValue, LeveledType.SkillLevel);
		setLevel(1);
		setLastTimes(setLastTurns(0));
		try {
			if (LastTime.charAt(LastTime.length() - 1) == 'T') {
				setLastTurns(Integer.parseInt(LastTime.substring(0, LastTime.length() - 1)));
			} else {
				setLastTimes(Integer.parseInt(LastTime));
			}
		} catch (NumberFormatException e) {
			System.out.println("SpecificSkillEffect������ʱ����ʽ����" + LastTime);
		}
	}
	
	abstract public void ValuedEffectOn(Battle battle, Unit self, double value);
	
	@Override
	public void EffectOn(Battle battle, Unit self) {
		ValuedEffectOn(battle, self, value.value(Level));
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}

	public int getLastTimes() {
		return LastTimes;
	}

	private void setLastTimes(int lastTimes) {
		LastTimes = lastTimes;
	}

	public int getLastTurns() {
		return LastTurns;
	}

	private int setLastTurns(int lastTurns) {
		LastTurns = lastTurns;
		return lastTurns;
	}
	
	
}
