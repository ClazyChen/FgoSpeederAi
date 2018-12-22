package com.clazy.trainer.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AttributeDisplay {
	
	/**
	 * ����������������ԣ����ж�Map��List����չ��
	 * ���ݹ�10��
	 */
	public void print() {
		tabbedOutput(this, 0, 0);
		System.out.println();
	}
	
	private static void tabbedOutput(Object ObjectInstance, int TabNumber, int RecusionDepth) {
		if (ObjectInstance == null) {
			System.out.print("null");
			return;
		}
		Runnable PrintTabs = () -> {
			for (int i = 0; i < TabNumber; ++ i) {
				System.out.print(" ");
			}
		};
		if (ObjectInstance instanceof List) {
			List<?> ListObject = (List<?>)ObjectInstance;
			if (ListObject.isEmpty()) {
				System.out.print("[]");
			} else {
				System.out.println("[");
				for (Object Item : ListObject) {
					PrintTabs.run();
					System.out.print("  ");
					if (RecusionDepth < 10 || Item == null) {
						tabbedOutput(Item, TabNumber + 2, RecusionDepth + 1);
					} else {
						System.out.print(Item.toString());
					}
					System.out.println(",");
				}
				PrintTabs.run();
				System.out.print("]");
			}
		} else if (ObjectInstance instanceof Map) {
			Map<?, ?> MapObject = (Map<?, ?>)ObjectInstance;
			if (MapObject.isEmpty()) {
				System.out.print("{}");
			} else {
				System.out.println("{");
				for (Object Key : MapObject.keySet()) {
					PrintTabs.run();
					System.out.print("  ");
					if (RecusionDepth < 10 || Key == null) {
						tabbedOutput(Key, TabNumber + 2, RecusionDepth + 1);
					} else {
						System.out.print(Key.toString());
					}
					System.out.print(" : ");
					if (RecusionDepth < 10 || MapObject.get(Key) == null) {
						tabbedOutput(MapObject.get(Key), TabNumber + 4, RecusionDepth + 1);
					} else {
						System.out.print(MapObject.get(Key).toString());
					}
					System.out.println(",");
				}
				PrintTabs.run();
				System.out.print("}");
			}
		} else if (ObjectInstance instanceof AttributeDisplay) {
			System.out.print("< ");
			System.out.print(ObjectInstance.getClass().getName());
			System.out.println(" :");
			List<Field> FieldList = new ArrayList<Field>();
			Class<? extends Object> TempClass = ObjectInstance.getClass();
			while (TempClass != null) {
				FieldList.addAll(Arrays.asList(TempClass.getDeclaredFields()));
				TempClass = TempClass.getSuperclass();
			}
			for (Field field : FieldList) {
				if (Modifier.isStatic(field.getModifiers())) {
					continue;
				}
				PrintTabs.run();
				System.out.print("  ");
				System.out.print(field.getName());
				System.out.print(" := ");
				boolean AccessFlag = field.isAccessible();
				field.setAccessible(true);
				try {
					Object FieldValue = field.get(ObjectInstance);
					if (FieldValue != null && (RecusionDepth >= 10 || field.getType().isPrimitive())) {
						System.out.print(FieldValue.toString());
					} else {
						tabbedOutput(FieldValue, TabNumber + 4, RecusionDepth + 1);
					}
				} catch (IllegalArgumentException e) {
					// �ղž��Ǵ����Object�ӵ���Field
					// ���Exception�����ܱ��ӵ�
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// �����Ѿ���Accessible���true��
					// ���Exception�����ܱ��ӵ�
					e.printStackTrace();
				}
				field.setAccessible(AccessFlag);
				System.out.println();
			}
			PrintTabs.run();
			System.out.print(">");
		} else {
			System.out.print(ObjectInstance.toString());
		}
	}
}
