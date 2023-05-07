package 프로그래머스.연습문제;

import java.util.PriorityQueue;
import java.util.Queue;

public class 요격시스템 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}}));
    }
    public static int solution(int[][] targets) {
        int answer = 0;
        Queue<Center> queue = new PriorityQueue<>();
        for (int i = 0; i < targets.length; i++) {
            queue.add(new Center(targets[i][0],targets[i][1]));
        }
        Center turn = queue.poll();

        while(!queue.isEmpty()) {
            Center center = queue.poll();
            if(center.s <= turn.s && center.e > turn.s) {
                continue;
            } else {
                turn.s = center.s;
                turn.e = center.e;
                answer +=1;
            }
        }
        return answer;
    }
}

class Center implements Comparable<Center>{
    int s;
    int e;

    public Center(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Center o) {
        if(this.s > o.s) {
            if(this.s == o.s && this.e > o.e) {
                return 1;
            } else {
                return -1;
            }

        } else {
            return -1;
        }
//        return this.s > o.s ? 1 : -1;
    }
}