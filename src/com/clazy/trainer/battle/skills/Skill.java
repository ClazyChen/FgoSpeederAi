package com.clazy.trainer.battle.skills;

import java.util.ArrayList;
import java.util.List;

import com.clazy.trainer.battle.Battle;
import com.clazy.trainer.tools.SkillEffect;
import com.clazy.trainer.unit.Unit;

public class Skill implements SkillEffect {
	
	private List<SpecificSkillEffect> EffectList;
	/**
	 * 等级为1时的CD
	 */
	private int CdAtFirst;

	private int Level;
	
	public Skill(int Cd) {
		setLevel(1);
		setEffectList(new ArrayList<SpecificSkillEffect>());
		setCdAtFirst(Cd);
	}
	
	public Skill AddEffect(SpecificSkillEffect effect) {
		getEffectList().add(effect);
		return this;
	}
	
	//以下是各种技能的原型
	public static Skill 现为脆弱的雪花之壁 = new Skill(7).AddEffect(new TeamEffect(new DefenseUpEffect(10, 15, "3T")));
	public static Skill 荣光坚毅的雪花之壁 = new Skill(7).AddEffect(new TeamEffect(new DefenseUpEffect(15, 20, "3T"))).
												AddEffect(new TeamEffect(new InjuryDownEffect(2000, 2000, "1")));
	
	
	
	//以上是各种技能的原型

	@Override
	public void EffectOn(Battle battle, Unit self) {
		for (SkillEffect effect : EffectList) {
			effect.EffectOn(battle, self);
		}
	}

	public int getLevel() {
		return Level;
	}

	public void setLevel(int level) {
		Level = level;
	}
	
	public int getCdAtFirst() {
		return CdAtFirst;
	}

	private void setCdAtFirst(int cdAtFirst) {
		CdAtFirst = cdAtFirst;
	}
	
	public List<SpecificSkillEffect> getEffectList() {
		return EffectList;
	}

	private void setEffectList(List<SpecificSkillEffect> effectList) {
		EffectList = effectList;
	}
	
}
