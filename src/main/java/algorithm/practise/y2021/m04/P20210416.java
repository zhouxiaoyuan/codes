package algorithm.practise.y2021.m04;

import algorithm.practise.ArrayFactory;

/**
 * @Description algorithm.practise.y2021.m04.P20210416
 * @Created by zhouxiaoyuan on 2021/4/15 9:23
 */
public class P20210416 {

    /**
     * @Author zhouxiaoyuan
     * @Description 前缀树作用: 找到对应的前缀是否存在
     * @Date 9:53 2021/4/15
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {

        int[] arrs = ArrayFactory.getArray();
        P20210416 p = new P20210416();
//        p.quickSort(arrs,0,arrs.length-1);
        p.gbSort(arrs, 0,arrs.length-1 );
        ArrayFactory.check(arrs);

        /*TrieTree trie = new TrieTree();
        trie.add("abc");
        System.out.println(trie.search("abc"));*/
    }

    public static class TrieTree{

        Trie root = new Trie();

        public void add(String s){
            if(s==null||s.length()==0){
                return ;
            }

            Trie node = root;
            node.p++;
            char[] chars = s.toCharArray();
            for(int i= 0 ; i < chars.length ; i++){
                int index = chars[i] - 'a';
                if(node.subs[index] == null){
                    node.subs[index] = new Trie();
                }
                node.subs[index].p++;
                node = node.subs[index];
            }
            node.e++;
        }

        public void delete(String s){
            if(s==null||s.length()==0){
                return ;
            }
            Trie node = root;
            char[] chars = s.toCharArray();
            for(int i = 0 ; i < chars.length;i++){
                int index = chars[i] - 'a';
                if(node.subs[index]!=null){
                    node.subs[index].p-- ;
                }
                if(node.subs[index].p == 0){
                    node.subs = new Trie[26];
                }
                node = node.subs[index];
            }
            node.e--;
        }

        public boolean search(String pre){
            if( pre==null||pre.length()==0){
                return false;
            }
            Trie node = root;
            char[] chars = pre.toCharArray();
            for(int i = 0 ; i < chars.length; i++){
                int index = chars[i] - 'a';
                if(node.subs[index]==null){
                    return false;
                }
                node = node.subs[index];
            }
            return true;
        }

    }

    public static class Trie{
        int p = 0 ;
        int e = 0 ;
        Trie[] subs = new Trie[26];

    }


    public void quickSort(int[] arrs , int l,int r ){
        if( arrs == null  || l >= r){
            return ;
        }

        int pivotIndex = findPivot(arrs ,l, r);
        quickSort(arrs,l, pivotIndex-1);
        quickSort(arrs, pivotIndex+1, r);

    }

    public int findPivot(int[] arrs , int l,int r){
        //找到中间的值
        int pivot = arrs[l];
        int mark = l;

        for( int i = l ; i <= r ; i++ ){
            if(arrs[i] < pivot ){
                mark++;
                int tmp = arrs[i];
                arrs[i] = arrs[mark];
                arrs[mark] = tmp;
            }
        }
        //TODO 忘记将mark的值拷贝到开始位置
        arrs[l] = arrs[mark];
        arrs[mark] = pivot;
        return mark;
    }

    public void gbSort(int[] arrs,int l ,int r){
        if(arrs==null || l>=r){
            return;
        }
        int mid = l + ((r-l)>>1);
        gbSort(arrs,l, mid);
        gbSort(arrs,mid+1, r);
        merge(arrs,l,mid,r);
    }

    public void merge(int[] arrs,int l ,int mid,int r){

        int p1 = l;
        int p2 = mid+1;
        int p = 0 ;
        int[] helper = new int[r-l+1];
        while( p1 <= mid && p2 <= r ){
            helper[p++] = arrs[p1] <= arrs[p2] ? arrs[p1++] : arrs[p2++];
        }
        while (p1<=mid){
            helper[p++] = arrs[p1++];
        }
        while(p2<=r){
           helper[p++] = arrs[p2++];
        }

        //TODO 忘记拷贝值到原始数组里
        for(int  i = 0 ; i < helper.length ; i++ ){
            arrs[l+i] = helper[i];
        }

    }

}

