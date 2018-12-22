package com.clazy.trainer.unit;

import java.util.ArrayList;
import java.util.List;

import com.clazy.trainer.tools.AttributeDisplay;

public class Unit extends AttributeDisplay {
	private static int UnitId = 0;
	
	protected int id;
	public int atk;
	public int hp;
	public String name;
	public Class clazz;
	public HiddenClass hiddenClass;
	public Sex sex;
	
	private List<Buff> buffs;
	
	public Unit() {
		setId(UnitId ++);
		atk = hp = 0;
		name = "";
		clazz = null;
		hiddenClass = null;
		sex = Sex.None;
		buffs = new ArrayList<Buff>();
	}
	
	/**
	 * 
	 * @return 职阶系数，默认值为1.0
	 */
	public double getClassCoeffient() {
		if (clazz == null) {
			return 1.0;
		} else {
			return clazz.ClassCoefficient;
		}
	}
	
	/**
	 * 
	 * @param Target
	 * @return 对目标单位的职阶克制系数，默认值为1.0
	 */
	public double getClassSuperiorityCoeffientOver(Unit Target) {
		if (Target == null || Target.clazz == null) {
			return 1.0;
		} else {
			return clazz.ClassSuperiorityCoeffientOver(Target.clazz);
		}
	}
	
	/**
	 * 根据命令设置属性， 如ATK 20为将ATK设为20
	 * @param OrderType 命令类型（ATK、HP、NAME、CLASS）
	 * @param OrderParam 命令参数
	 * @return 正确运行返回0，错误输入返回1
	 */
	public int setAttributeByOrder(String OrderType, String OrderParam) {
		if (OrderType.equals("ATK")) {
			try {
				atk = Integer.parseInt(OrderParam);
			} catch (NumberFormatException e) {
				System.out.println(String.format("Unit.setAttributeByOrder：错误的ATK数据输入：%s", OrderParam));
			}
		} else if (OrderType.equals("HP")) {
			try {
				hp = Integer.parseInt(OrderParam);
			} catch (NumberFormatException e) {
				System.out.println(String.format("Unit.setAttributeByOrder：错误的HP数据输入：%s", OrderParam));
			}
		} else if (OrderType.equals("NAME")) {
			name = OrderParam;
		} else if (OrderType.equals("CLASS")) {
			boolean CorrectClass = false;
			if (OrderParam.length() == 1) {
				char OrderClass = OrderParam.charAt(0);
				switch (OrderClass) {
				case '1': clazz = Class.BeastI; break;
				case '2': clazz = Class.BeastII; break;
				case '3': clazz = Class.BeastIII; break;
				default: clazz = Class.getBySymbol(OrderClass); break;
				}
				if (clazz != null) {
					CorrectClass = true;
				}
			} 
			if (!CorrectClass) {
				System.out.println(String.format("Unit.setAttributeByOrder：错误的职阶数据输入：%s", OrderParam));
				return 1;
			}
		}
		return 0;
	}

	
	public int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	
	public void getBuff(Buff buff) {
		buffs.add(buff);
	}
}
