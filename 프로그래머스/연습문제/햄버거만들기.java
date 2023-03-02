package 프로그래머스.연습문제;

import java.util.Stack;

public class 햄버거만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }
    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int[] order = new int[]{1,2,3,1};
        int[] cook = new int[]{0,0,0,0};
//        String cook = "1231";
        StringBuilder temp = new StringBuilder();

        return answer;
    }
}
