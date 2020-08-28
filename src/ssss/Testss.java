package ssss;

/**
 * ClassName:Testss
 * Package:ssss
 * Description:
 *
 * @Date:2020-08-27 13:43
 * @Author:yuhao@xhu.com
 */

public class Testss {
    public static void main(String[] args) {
        Integer i = 11111;
        Integer i3 = new Integer(1111);
        Integer i2 = 11111;
        Long i1 = 11111L;
        System.out.println(i.equals(i1));// false
        System.out.println(i.equals(i2));// true
        System.out.println(i == i2);// false
        System.out.println(i3);// 1111


        int q = 2;
        long w = 2L;
        System.out.println(q == w);// true

        Integer integer2 = Integer.valueOf("10", 16);
        System.out.println(integer2);// 16
        Integer integer = Integer.valueOf("5916", 16);
        System.out.println(integer);// 22806
        char returnStr = (char) Integer.valueOf("5916", 16).intValue();
        System.out.println(returnStr);// 外
        char returnStr1 = (char) 22806;
        System.out.println(returnStr1);// 外
        SubThread2 subThread2 = new SubThread2();
        subThread2.start();
    }


}

 class SubThread2 extends Thread {
    public SubThread2() {
        System.out.println(" 构 造 方 法 中 ,Thread.currentThread().getName() : " + Thread.currentThread().getName());
        System.out.println("构造方法,this.getName() : " + this.getName());
    }

    @Override
    public void run() {
        System.out.println("run 方 法 中 ,Thread.currentThread().getName() : " + Thread.currentThread().getName());
        System.out.println("run 方法,this.getName() : " + this.getName());
    }
}
