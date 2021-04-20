package algorithm.practise;

import java.util.*;

/**
 * @Description algorithm.practise.LineFactory
 * @Created by zhouxiaoyuan on 2021/4/20 15:15
 */
public class LineFactory {

    public static List<Line> getLines(int size,int scope){
        List<Line> list = new ArrayList<>(size);

        Random random = new Random();
        int start = 0 ,end = 0 ;
        for (int i = 0; i < size ; i++) {
            start = random.nextInt(scope);
            while( (end = random.nextInt(scope)) <= start){}
            list.add( new Line(start,end) ) ;
        }
        return list;
    }

    public static void main(String[] args) {
        List list = LineFactory.getLines(100, 1000);
        System.out.println(list.toString());
        Line[] lines = new Line[list.size()];
        list.toArray(lines);
        getMaxOverLine(lines);

        Map<Double,Integer> map = new HashMap();
        for (int i = 0; i < lines.length ; i++) {
            double point = lines[i].start + 0.5;
            while( point < lines[i].end ){
                if( !map.containsKey(point)){
                    map.put(point, 0);
                }
                map.put(point, map.get(point) + 1 );
                point++;
            }
        }
        int m  = 0 ;
        for( int i : map.values()){
            if( i > m){
              m = i;
            }
        }
        System.out.println("求点法:" + m);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length ; i++ ) {
            Line line = lines[i];
            while( queue.size() > 0 && queue.peek() < line.start ){
                queue.poll();
            }
            queue.offer(line.end);
            max = Math.max(max,queue.size());
        }
        System.out.println(max);
    }

    public static int getMaxOverLine(Line[] arrs){
        if(arrs==null){
            return 0;
        }
        int result = 0 ;
        Arrays.sort(arrs, new LineComparetor());

        System.out.println(Arrays.toString(arrs));

        return -1;
    }


}

class LineComparetor implements Comparator<Line>{

    @Override
    public int compare(Line o1, Line o2) {
        return o1.start - o2.start ;
    }
}

class Line implements Comparable<Line>{
    int start ;
    int end;

    public Line(int s , int e){
        start = s;
        end = e;
    }

    @Override
    public int compareTo(Line o) {
        return this.start - o.start ;
    }

    @Override
    public String toString() {
        return "Line{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
