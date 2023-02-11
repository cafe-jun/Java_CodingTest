package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("foobar"));
    }
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            answer[i] = i-map.getOrDefault(ch,i+1);
            map.put(ch,i);
        }
        return answer;
    }
}
