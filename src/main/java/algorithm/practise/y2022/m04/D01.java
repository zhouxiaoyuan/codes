package algorithm.practise.y2022.m04;

public class D01 {

    public static void main(String[] args) {

        String str1 = "safasdfdsafsd1abababc";
        String str2 = "ababc";
        System.out.println(indexOf(str1,str2));;
    }

    public static int indexOf(String str1 , String str2){
        if(str1 == null || str2 == null || str1.length() < str2.length() ){
            return -1;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int[] next = getnext(str2);
        int x = 0 ;
        int y = 0;

        while( x < str1.length() && y < str2.length()){
            if(s1[x] == s2[y]){
                x++;
                y++;
            }/*else if( next[y] == -1 ){
                x++;
            }else{
                y = next[y];
            }*/
            else if( next[y] > 0  ){  //此处根据next数据，跟下面的获取next数组相似
                y = next[y];
            }else{
                x++;
            }

        }

        return y == s2.length ? x - y : -1;

    }


    public static int[] getnext(String str2){
        int[] next = new  int[str2.length()];

        int i = 2;
        int cn = 0 ;
        next[0] = -1;
        next[1] = 0;

        char[] s2 = str2.toCharArray();

        while( i < str2.length() ){
            if( s2[i-1] == s2[cn]){
                next[i++] = ++cn;
            }else if( next[cn] > 0 ){
                cn = next[cn];
            }else{
                next[i++] = 0;
            }
        }

        return next;
    }
}
