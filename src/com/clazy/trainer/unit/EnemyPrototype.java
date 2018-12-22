package com.clazy.trainer.unit;

import java.util.List;
import java.util.Map;

import com.clazy.trainer.tools.SkillEffect;

public class EnemyPrototype extends Enemy {
	
	private static Map<Integer, EnemyPrototype> NpcIdList;
	
	private List<Integer> NpcId;
	private double ImmediatelyDiePossibility;
	private double CriticalPossibility;
	private double DefenseStarRate;
	private double DefenseNpRate;
	private double AttackNpRate;
	
	private List<SkillEffect> SkillList;
}
