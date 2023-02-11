package 프로그래머스.연습문제;

import java.util.PriorityQueue;

public class 디펜스게임 {
    public static void main(String[] args) {
//        System.out.println(solution(7,3,new int[]{4, 2, 4, 5, 3, 3, 1}));
        System.out.println(solution(2,4,new int[]{3,3,3,3,3,3,3,3,3,3,3}));
//        System.out.println(solution(7, 3,new int[]{5, 5, 5, 5, 2, 3, 1}));
//        System.out.println(solution(1, 6, new int[]{2, 2, 2, 2, 3, 3, 1}));
//        System.out.println(solution(10, 1,new int[]{2, 2, 2, 2, 2, 10}));
//        System.out.println(solution(10, 1,new int[] {2, 2, 2, 2, 10}));
    }
    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(k>=enemy.length) {
            return k;
        }
        PriorityQueue<Enemys> queue = new PriorityQueue<>();

        for (int i = 0; i < enemy.length; i++) {
            queue.offer(new Enemys(i,enemy[i]));
        }

        for (int i = 0; i < k; i++) {
            Enemys enemys = queue.poll();
            enemy[enemys.getIndex()] = 0;
        }
        for (int i = 0; i < enemy.length; i++) {

            if(n-enemy[i] < 0) {
                break;
            }
            System.out.println("디펜스게임.solutiontest");
            n-= enemy[i];
            answer +=1;
        }
        return answer;
    }
}

class Enemys implements Comparable<Enemys>{
    private int index;

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }

    private  int value;

    public Enemys(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Enemys o) {
         if(this.value < o.value) {
           return 1;
         } else if (this.value == o.value) {
             return this.index > o.index ? 1: -1;
         } else {
             return -1;
         }
    }
}