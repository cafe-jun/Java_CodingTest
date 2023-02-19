package 프로그래머스.연습문제;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class 과일장수 {
    public static void main(String[] args) {
//        System.out.println(solution(3,4,new int[]{1, 2, 3, 1, 2, 3, 1}));
        System.out.println(solution(4,3,new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }
    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        int[] sortScore = Arrays.stream(score).boxed().sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();;
        int boxCnt = sortScore.length / m;
        Stack<AppleStatus> stack = new Stack<>();
        for (int i = 0; i < boxCnt; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                temp[j] = sortScore[(m*i)+j];
            }

            if(!stack.isEmpty() && stack.peek().equalsArray(temp)){
                stack.peek().setCount(1);
            } else {
                stack.push(new AppleStatus(temp));
            }
        }
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            AppleStatus appleStatus = stack.pop();
            answer += appleStatus.getPrice();
        }
        return answer;
    }
}
class AppleStatus {
    int[] apple;
    int count;

    public AppleStatus(int[] apple) {
        this.apple = apple;
        this.count = 1;
    }
    public boolean equalsArray(int[] arr) {
        for (int i = 0; i < this.apple.length; i++) {
            if(arr[i] != apple[i]) {
                return false;
            }
        }
        return true;
    }

    public void setCount(int count) {
        this.count += count;
    }
    public int getPrice() {
        return this.apple[this.apple.length-1]*this.apple.length*this.count;
    }
}
