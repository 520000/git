/*
 * java.lang.reflect.Field;类中的属性
 *
 */

package ssss;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Properties;

public abstract class ReflectTest04 {

	public InputStream getInputStream() throws Exception {
		throw new RuntimeException("protocol doesn't support input");
	}

	public static void main(String[] args) throws Exception {



		// 获取整个类
		Class c = Class.forName("ssss.User");

		ClassLoader classLoader = ReflectTest04.class.getClassLoader();
		InputStream d = classLoader.getResourceAsStream("dbinfo.properties");
		Properties d1 = new Properties();
		d1.load(d);
		// 获取属性Field
/*		Field[] fs = c.getFields();
		System.out.println(fs.length);// 1
		System.out.println(fs[0].getName());// age
		*/
		// 获取所有的属性？
		Field[] fs = c.getDeclaredFields();
/*		for(Field field:fs){
 *
			int i = field.getModifiers();
			// System.out.println(i);// 2 1 4 0
			String strModifier = Modifier.toString(i);
			System.out.println(strModifier);
			// private public protected  空
			
			Class type = field.getType();
			System.out.println(type.getSimpleName());
			// String	int	 String	boolean
			// System.out.println(type.getName());
			// java.lang.String	int	 java.lang.String	boolean
			 * 
			System.out.println(field.getName());// id age addr sex
		}*/
		StringBuffer sb = new StringBuffer();
		sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+"{\n");
		for(Field field:fs){
			sb.append("\t");
			sb.append(Modifier.toString(field.getModifiers()));
			sb.append(" "+field.getType().getSimpleName());
			sb.append(" "+field.getName()+";"+"\n");

		}
		sb.append("}");
		System.out.println(sb);
	}

}
