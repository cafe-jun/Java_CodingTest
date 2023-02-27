package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"},new int[]{3, 2, 2, 2, 1},new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(solution(new String[]{"apple"},new int[]{10},new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }
    public static int solution (String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i],number[i]);
        }

        for (int i = 0; i < 10; i++) {
            if(wantMap.containsKey(discount[i])) {
                if(wantMap.get(discount[i]) > 1) {
                    wantMap.put(discount[i],wantMap.get(discount[i])-1);
                } else {
                    wantMap.remove(discount[i]);
                }
            }
        }


        return answer;
    }
}
