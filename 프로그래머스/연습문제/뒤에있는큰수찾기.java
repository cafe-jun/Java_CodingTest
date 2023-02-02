package 프로그래머스.연습문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Stack;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 3, 5}));
        System.out.println(solution(new int[]{9, 1, 5, 3, 6, 2}));
    }
    public static int[] solution(int[] numbers) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[numbers.length];

        for(int i=0 ; i<numbers.length ; i++) {
            // 하강 직선일 때는 push
            if(stack.isEmpty() || numbers[i]<numbers[i-1]) {
                stack.push(i);
            } else {
                // 현재값보다 작은 index는 pop하여 현재값으로
                while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]) {
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
            }
        }
        // 나머지는 -1
        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }
}

class Num implements Comparable<Num> {
    int value;
    int index;

    public Num(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Num target) {
        // 역순으로 정렬
        return this.value<= target.value ? -1 : 1;
    }
}