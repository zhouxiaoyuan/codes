package algorithm.practise.y2022.m04;

public class D02 {

    public static void main(String[] args) {
        System.out.println( manacher("xxx12e21s3") );
    }

    public static int manacher(String s){

        int C = 0 ;
        int R = 0 ;
        String ms = manacherString(s);
        char[] ss = ms.toCharArray();

        int[] ptr = new int[ss.length];
        int max = Integer.MIN_VALUE;

        int i  = 0 ;
        while( i < ss.length ){
            if(R > i)  {
                ptr[i] = Math.min(ptr[2*C-i],R-i);
            }else{
                ptr[i] = 1;
            }

            while( i - ptr[i] > -1  && i + ptr[i] < ss.length ){
                if( ss[i-ptr[i]] == ss[i+ptr[i]] ){
                    ptr[i]++;
                }else {
                    break;
                }
            }
            if( i + ptr[i] > R){
                R = i + ptr[i];
                C = i;
            }
            if( ptr[i] > max){
                max = ptr[i];
            }
            i++;
        }

        return max-1;
    }

    public static String manacherString(String s){
        char[] chars = new char[ 2*s.length() + 1 ];
        int i = 0 ;
        int j = 0 ;
        while(i < chars.length){
            if( (i & 1) == 1){
                chars[i++] = s.charAt(j++);
            }else{
                chars[i++] = '#';
            }
        }
        return new String(chars);
    }
}

