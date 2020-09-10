package ssss;

/**
 * ClassName:dflsjdf
 * Package:ssss
 * Description:
 *
 * @Date:2020-08-28 12:31
 * @Author:yuhao@xhu.com
 */

public class dflsjdf {
    public static void main(String[] args) {
        int a = 0;
        int b = 0;
        for(int z = 0; z < 99;++z){
            a = a++;
            b = a++;
        }
        System.out.println(a +""+b);
        int d = 1;
        d = d++;
        System.out.println(d);//1
        d = 1;
        d = ++d;
        System.out.println(d);//2
    }
}
