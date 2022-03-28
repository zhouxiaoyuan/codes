package algorithm.practise.y2022.m03;

public class D28 {

    public static void main(String[] args) {
        int i = 6;
        int rightOne = getRightOne(i);
        System.out.println(rightOne);



    }



    public static int getRightOne(int i){
        if(i==0)return 0;
        return  i & (-i);
    }
}
