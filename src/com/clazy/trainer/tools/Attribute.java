package com.clazy.trainer.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Attribute {
	public String Name;
	public char Symbol;
	protected Attribute(String _Name, char _Symbol) {
		Name = _Name;
		Symbol = _Symbol;
	}
	
	@Override
	public String toString() {
		return Name;
	}
	
	protected static Attribute getBySymbol(char TargetSymbol, Class<? extends Attribute> SelfClass) {
		Field[] FieldList = SelfClass.getFields();
		for (Field Item : FieldList) {
			if (SelfClass.isAssignableFrom(Item.getType()) &&
					Modifier.isPublic(Item.getModifiers()) && Modifier.isStatic(Item.getModifiers())) {
				try {
					Attribute Instance = (Attribute)(Item.get(null));
					if (Instance.Symbol == TargetSymbol) {
						return Instance;
					}
				} catch (IllegalArgumentException e) {
					System.out.println(String.format("Attribute,getBySymbol��δ֪����������%s�༰%c���",
							SelfClass.getName(), TargetSymbol));
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					System.out.println(String.format("Attribute,getBySymbol���ɷ����Դ�����%s�༰%c���",
							SelfClass.getName(), TargetSymbol));
					e.printStackTrace();
				}
			}
		}
		return null;
	}
}
