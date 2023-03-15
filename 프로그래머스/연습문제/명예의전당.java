package 프로그래머스.연습문제;

import java.util.*;

public class 명예의전당 {
    public static void main(String[] args) {
        System.out.println(solution(3,new int[]{10, 100, 20, 150, 1, 100, 200}));
        System.out.println(solution(4,new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}));

    }
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <score.length ; i++) {
            list.add(score[i]);
            Collections.sort(list);
            if (list.size() > k) {
                list.remove(0);

            }
            answer[i] = list.get(0);
        }

        return answer;
    }
}
