package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 둘만의암호 {
    public static void main(String[] args) {
        System.out.println(solution("aukks",	"wbqd",	5));
    }
    public static String solution(String s, String skip, int index) {
        String answer = "";
        // char 97 ~ 122
        Map<Integer,Integer> map = new HashMap<>();
        String a = "a";
        String z = "z";
        for (int i = a.charAt(0); i <= z.charAt(0); i++) {
            for (int j = 0; j < skip.length(); j++) {
                if (skip.charAt(j)) {

                }
                map.put()
            }
        }
        return answer;
    }
}
