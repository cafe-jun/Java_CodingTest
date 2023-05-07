package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;

public class 추억점수 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"may", "kein", "kain", "radi"},new int[]{5, 10, 1, 3},new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}}));
        System.out.println(solution(new String[]{"kali", "mari", "don"},new int[]{11, 1, 55},new String[][]{{"kali", "mari", "don"},{"pony", "tom", "teddy"}, {"con", "mona", "don"}}));
        System.out.println(solution(new String[]{"may", "kein", "kain", "radi"},new int[]{5, 10, 1, 3},new String[][]{{"may"},{"kein", "deny", "may"}, {"kon", "coni"}}));
    }
    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> points = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            points.put(name[i],yearning[i]);
        }
        for (int i = 0; i < photo.length; i++) {
            int total = 0;
            for (int j = 0; j < photo[i].length; j++) {
                if(points.containsKey(photo[i][j])){
                    total += points.get(photo[i][j]);
                }
            }
            answer[i] = total;
        }
        return answer;
    }
}

