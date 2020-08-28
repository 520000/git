package ssss;

import java.lang.reflect.*;

public class ReflectTest07 {
	public static void main(String[] args) throws Exception {
		// 1.��ȡ��
		Class c = Class.forName("����.CustomerService");

		/*
		 * // ��ȡĳ���ض����� Method m = c.getDeclaredMethod("login");//����û��
		 * ����.CustomerService.login()����
		 * // ��ȡ�ض����� 
		 * Field idF = c.getDeclaredField("id");
		 */

		// ��ȡĳ���ض��ķ���
		// ͨ����������+�β��б�
		Method m = c.getDeclaredMethod("login", String.class, String.class);

		// ͨ���������ִ��login����
		Object o = c.newInstance();

		// ����o�����m����������"admin""123"������������ִ�н����retValue
		Object retValue = m.invoke(o, "admin", "123");

		System.out.println(retValue);// true

	}

}
