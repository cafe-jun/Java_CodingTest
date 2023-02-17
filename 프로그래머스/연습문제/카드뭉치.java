package 프로그래머스.연습문제;


import java.util.LinkedList;
import java.util.Queue;

public class 카드뭉치 {
    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"i", "drink", "water"},new String[]{"want", "to"},new String[]{"i", "want", "to", "drink", "water"}));
        System.out.println(solution(new String[]{"i", "drink", "water"},new String[]{"want", "to"},new String[]{"i", "want", "to", "water", "drink"}));
    }
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> queue1 = new LinkedList<>();
        for (int i = 0; i < cards1.length; i++) {
            queue1.offer(cards1[i]);
        }
        Queue<String> queue2 = new LinkedList<>();
        for (int i = 0; i < cards2.length; i++) {
            queue2.offer(cards2[i]);
        }
        for (int i = 0; i < goal.length; i++) {
            if(!queue1.isEmpty() && queue1.peek().equals(goal[i])) {
                queue1.poll();
                continue;
            } else if (!queue2.isEmpty() && queue2.peek().equals(goal[i])) {
                queue2.poll();
                continue;
            }
            return "No";
        }
        return answer;
    }
}
