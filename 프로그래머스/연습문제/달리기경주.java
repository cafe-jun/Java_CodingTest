package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "mine", "mine"}));
    }
    private static String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String,Integer> race = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            race.put(players[i],i);
        }
        for (int i = 0; i < callings.length; i++) {
            int callPlayerRanking = race.get(callings[i]);
            if(callPlayerRanking > 0) {
                String frontPlayerRanking = players[callPlayerRanking-1];
                race.put(callings[i],callPlayerRanking-1);
                race.put(frontPlayerRanking,callPlayerRanking);
                // 앞선 썬수가 뒤로 밀림
                players[callPlayerRanking-1] = callings[i];
                // call 한 선수를 앞찌름
                players[callPlayerRanking] = frontPlayerRanking;


            };
        }
        answer = players;
        return answer;
    }
}
