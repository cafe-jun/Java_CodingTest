package 프로그래머스.연습문제;

import java.util.Stack;

public class 햄버거만들기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }

    //1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기
    //순서 빵 – 야채 – 고기 - 빵
    public static int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        String recipe = new String("1321");
        for (int i = 0; i < ingredient.length; i++) {

            stack.push(ingredient[i]);
            if(stack.size() >= 4) {
                StringBuilder temp = new StringBuilder();
                Stack<Integer> tempStack = new Stack<>();
                for (int j = 0; j < 4; j++) {
                    tempStack.push(stack.peek());
                    temp.append(stack.pop());
                }
                if(temp.toString().equals(recipe)) {
                    answer += 1;
                } else {
                    for (int j = 0; j < 4; j++) {
                        stack.push(tempStack.pop());
                    }
                }
            }
        }

        return answer;
    }
}
