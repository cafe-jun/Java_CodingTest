package 프로그래머스.연습문제;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 택배상자 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 1, 2, 5}));
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}));
    }
    public static int solution(int[] order) {
        int answer = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer>  main= new LinkedList<>();
        for (int i = 0; i < order.length; i++) {
            main.offer(i+1);
        }
        Stack<Integer> sub = new Stack<>();
        for (int i = 0; i < order.length; i++) {
            if(!main.isEmpty() && main.peek() == order[i]) {
                list.add(main.poll());
            } else if(!main.isEmpty() && main.peek()<order[i]) {
                while(main.peek()<order[i]) {
                    sub.push(main.poll());
                }
                i--;
            } else if (!sub.isEmpty() && sub.peek() == order[i]) {
                list.add(sub.pop());
            } else {
                break;
            }
        }
        answer = list.size();
        return answer;
    }
}
