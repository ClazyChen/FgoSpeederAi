package com.clazy.trainer.battle;

import com.clazy.trainer.tools.AttributeDisplay;
import com.clazy.trainer.tools.SkillEffect;
import com.clazy.trainer.unit.Unit;

abstract public class NoblePhantasm extends AttributeDisplay {

	public String Name;
	public NoblePhantasmType type;
	
	protected SkillEffect SideEffect;
	
	public NoblePhantasm() {
		SideEffect = NoSideEffect;
	}
	
	public NoblePhantasm(SkillEffect _SideEffect) {
		SideEffect = _SideEffect;
	}
	
	abstract public void Release(Battle battle);
	
	protected static SkillEffect NoSideEffect = new SkillEffect() {
		
		@Override
		public void EffectOn(Battle battle, Unit self) {
			//什么也不做
		}
	};
}
