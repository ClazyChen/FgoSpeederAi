package com.clazy.trainer;

import java.util.ArrayList;
import java.util.List;

import com.clazy.trainer.tools.AttributeDisplay;
import com.clazy.trainer.unit.Enemy;

public class Phase extends AttributeDisplay {
	private List<Enemy> Enemies;
	
	public Phase() {
		setEnemies(new ArrayList<Enemy>());
	}

	public List<Enemy> getEnemies() {
		return Enemies;
	}

	private void setEnemies(List<Enemy> enemies) {
		Enemies = enemies;
	}
}
