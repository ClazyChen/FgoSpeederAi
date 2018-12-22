package com.clazy.trainer.tools;

import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.unit.Unit;

public interface SkillEffect {
	public void EffectOn(Battle battle, Unit self);
}
