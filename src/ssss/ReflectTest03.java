package ssss;/*
 * ???Class??????????????????��????????
 */


import java.util.Date;
import java.text.*;
public class ReflectTest03 {
	public static void main(String[] args) throws ClassNotFoundException,
	InstantiationException, IllegalAccessException {
		Class c = Class.forName("????.Employee");
		
		// ??????Class??????????????????????
		Object o = c.newInstance();// ??????Employee???????????????
		System.out.println(o);// ????.Employee@8d80be3
		
		Class c1 = Class.forName("java.util.Date");
		Object o1 = c1.newInstance();
		
		if(o1 instanceof Date){
			Date t = (Date)o1;
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(t));
			// 2019-06-29 19:34:32 150
		}
	}

}
