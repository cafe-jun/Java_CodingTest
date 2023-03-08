package 프로그래머스.연습문제;

import java.util.*;

public class 숫자짝궁 {
    public static void main(String[] args) {
        System.out.println(solution("100","2345"));
        System.out.println(solution("100","203045"));
        System.out.println(solution("100","123450"));
        System.out.println(solution("12321","42531"));
        System.out.println(solution("5525","1255"));

    }
    public static String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
//        String answer = "";
        Map<Character,Integer> xMap = new HashMap<>();
        for (int i = 0; i < X.length(); i++) {
            xMap.put(X.charAt(i),xMap.getOrDefault(X.charAt(i),0)+1);
        }
        Map<Character,Integer> equalMap = new HashMap<>();
        for (int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            if(xMap.containsKey(c)) {
                equalMap.put(c,equalMap.getOrDefault(c,0)+1);
                xMap.put(c,xMap.get(c)-1);
                int cnt = xMap.get(c);
                if(cnt <= 0) {
                    xMap.remove(c);
                }
            }
        }
        List<Character> keySet = new ArrayList<>(equalMap.keySet());
        Collections.sort(keySet,Collections.reverseOrder());
        for (Character c: keySet) {
            Integer cnt = equalMap.get(c);
            for (int i = 0; i < cnt; i++) {
                answer.append(Character.toString(c));
            }
        }

        if(answer.toString().equals("")) {
            return "-1";
        } else if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer.toString();
    }
}
