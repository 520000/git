package ssss;

public class ReflectTest02 {
	public static void main(String[] args) throws ClassNotFoundException{
		// 将A.class文件装载到JVM中的过程。会执行静态语句块
		// Class.forName("ssss.A");

		// 不会执行静态语句块
		// Class c = A.class;

		// 会执行
		A a = new A();
		Class c = a.getClass();
	}
}
class A{
	static{
		System.out.println("A...");
	}
}