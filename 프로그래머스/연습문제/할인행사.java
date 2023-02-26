package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;

public class 할인행사 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"},new int[]{3, 2, 2, 2, 1},new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"}));
        System.out.println(solution(new String[]{"apple"},new int[]{10},new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
        System.out.println(solution(new String[]{"banana"},new int[]{10},new String[]{"banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana", "banana"}));
    }
    public static int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> wantMap = new HashMap<>();
        Map<String,Integer> wantListMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i],number[i]);
            wantListMap.put(want[i],1);
        }

        for (int i = 0; i < 10; i++) {
            if(wantMap.containsKey(discount[i])) {
                wantMap.put(discount[i],wantMap.get(discount[i])-1);
            }

        }
        if(wantMap.size() == 0) {
            answer +=1;
        }
        for (int i = 10; i < discount.length; i++) {
            if(wantListMap.containsKey(discount[i-10])) {
                wantMap.put(discount[i-10],wantMap.getOrDefault(discount[i-10],0));

            }
        }


        return answer;
    }

}
