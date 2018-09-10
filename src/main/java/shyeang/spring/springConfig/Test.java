package shyeang.spring.springConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test {
    public  static  void  main(String [] args){
        String [] dd = {"abcd","cdab","adcb","cbad"};
//        System.out.println(numSpecialEquivGroups(dd));
System.out.println("abcd".substring(0, 1) + "abcd".substring(2, 3));
    }

    public static int numSpecialEquivGroups(String[] A) {
        if(A == null){
            return 0;
        }
        List<String> arrList =  Arrays.asList(A);
        List<String> ls = new ArrayList(arrList);

        int res = 0;


        while(ls != null && ls.size() > 0){
            String sf = ls.get(0);
            ls.remove(0);
            res++;
            for(int j = 0;j<ls.size();){
                if(is(sf, ls.get(j))){
                    ls.remove(j);
                } else{
                    j++;
                }
            }
        }

        return res ;

    }

    public static boolean is(String a, String b){
        if(a == null || b == null || a.length() != b.length()){
            return false;
        }
        return isEqual(a, b) && isEqual(b, a);
    }

    public static boolean isEqual(String a, String b) {

        System.out.println(a + "---" + b + "---");

        for (int i = 0; i < a.length();) {
            boolean bl = false;
            for(int j = 0;j<b.length();j++){
                if(a.charAt(i) == b.charAt(j)){
                    bl = true;
                    a = a.substring(1, a.length());
                    b = b.substring(0, j) + b.substring(j+1, b.length());
                    break;
                }
                if(bl == false){
                    return  false;
                }
            }
        }
        System.out.println("2---");
        return  true;
    }

}
