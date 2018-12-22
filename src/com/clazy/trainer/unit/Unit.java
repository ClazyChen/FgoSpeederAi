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
	 * @return ְ��ϵ����Ĭ��ֵΪ1.0
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
	 * @return ��Ŀ�굥λ��ְ�׿���ϵ����Ĭ��ֵΪ1.0
	 */
	public double getClassSuperiorityCoeffientOver(Unit Target) {
		if (Target == null || Target.clazz == null) {
			return 1.0;
		} else {
			return clazz.ClassSuperiorityCoeffientOver(Target.clazz);
		}
	}
	
	/**
	 * ���������������ԣ� ��ATK 20Ϊ��ATK��Ϊ20
	 * @param OrderType �������ͣ�ATK��HP��NAME��CLASS��
	 * @param OrderParam �������
	 * @return ��ȷ���з���0���������뷵��1
	 */
	public int setAttributeByOrder(String OrderType, String OrderParam) {
		if (OrderType.equals("ATK")) {
			try {
				atk = Integer.parseInt(OrderParam);
			} catch (NumberFormatException e) {
				System.out.println(String.format("Unit.setAttributeByOrder�������ATK�������룺%s", OrderParam));
			}
		} else if (OrderType.equals("HP")) {
			try {
				hp = Integer.parseInt(OrderParam);
			} catch (NumberFormatException e) {
				System.out.println(String.format("Unit.setAttributeByOrder�������HP�������룺%s", OrderParam));
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
				System.out.println(String.format("Unit.setAttributeByOrder�������ְ���������룺%s", OrderParam));
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
