package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 귤고르기 {
    public static void main(String[] args) {
        System.out.println(solution(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution( 4,new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution( 2,new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
    public static int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <tangerine.length ; i++) {
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        PriorityQueue<Tangerine> queue = new PriorityQueue();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new Tangerine(entry.getKey(), entry.getValue()));
        }
        while(!queue.isEmpty()){
            Tangerine tan = queue.poll();
            if(k>0) {
                k -= tan.getCount();
                answer += 1;
            } else {
                break;
            }
        }
        return answer;
    }
}

class Tangerine implements Comparable<Tangerine> {
    public int getNum() {
        return num;
    }

    public int getCount() {
        return count;
    }

    private int num;
    private int count;

    public Tangerine(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public int compareTo(Tangerine o) {
        // 내림 차순
        return this.count <= o.count ? 1: -1;
    }
}
