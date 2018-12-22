package com.clazy.trainer.tools;

public class LeveledValue extends AttributeDisplay {
	private double LowerBoundValue;
	private double UpperBoundValue;
	private LeveledType type;
	
	public LeveledValue(double Lower, double Upper, LeveledType _type) {
		setLowerBoundValue(Lower);
		setUpperBoundValue(Upper);
		setType(_type);
	}
	
	/**
	 * 给定等级，返回在该等级下的值
	 * 宝具为折半增长，OC为平均增长，技能为十等分最后一格双倍
	 * @param Level
	 * @return
	 */
	public double value(int Level) {
		if (type.equals(LeveledType.NoblePhantasmLevel)) {
			switch (Level) {
			case 1: return LowerBoundValue;
			case 2: return LowerBoundValue * 0.5 + UpperBoundValue * 0.5;
			case 3: return LowerBoundValue * 0.25 + UpperBoundValue * 0.75;
			case 4: return LowerBoundValue * 0.125 + UpperBoundValue * 0.875;
			case 5: return UpperBoundValue;
			default: break;
			}
		} else if (type.equals(LeveledType.NoblePhantasmOcLevel)) {
			if (1 <= Level && Level <= 5) {
				return LowerBoundValue * (1.25 - 0.25 * Level) + UpperBoundValue * (0.25 * Level - 0.25);
			}
		} else if (type.equals(LeveledType.SkillLevel)) {
			if (Level == 10) {
				return UpperBoundValue;
			} else if (1 <= Level && Level <= 9) {
				return LowerBoundValue * (1.1 - 0.1 * Level) + UpperBoundValue * (0.1 * Level - 0.1);
			}
		}
		System.out.println(String.format("LeveledValue.value：错误的等级参数：%d", Level));
		return 0.0;
	}
	
	public LeveledType getType() {
		return type;
	}
	public void setType(LeveledType type) {
		this.type = type;
	}

	public double getUpperBoundValue() {
		return UpperBoundValue;
	}

	public void setUpperBoundValue(double upperBoundValue) {
		UpperBoundValue = upperBoundValue;
	}

	public double getLowerBoundValue() {
		return LowerBoundValue;
	}

	public void setLowerBoundValue(double lowerBoundValue) {
		LowerBoundValue = lowerBoundValue;
	}
}
