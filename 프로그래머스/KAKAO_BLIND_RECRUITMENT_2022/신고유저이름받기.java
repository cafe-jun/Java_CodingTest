package 프로그래머스.KAKAO_BLIND_RECRUITMENT_2022;

import java.util.*;

public class 신고유저이름받기 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "frodo", "apeach", "neo"},new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2));
        System.out.println(solution(new String[]{"con", "ryan"},new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},3));
    }
    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        // 내가 신고 당한 유
        Map<String, HashSet<String>> map = new HashMap<>();
        // 내가 신고한 유저
        Map<String, HashSet<String>> tmap = new HashMap<>();
        Map<String,Integer> result = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            result.put(id_list[i],0);
        }

        for (int i = 0; i < report.length; i++) {
            String[] r = report[i].split(" ");
            if(map.containsKey(r[1])) {
                map.get(r[1]).add(r[0]);
            } else {
                map.put(r[1],new HashSet<>());
                map.get(r[1]).add(r[0]);
            }
            if(tmap.containsKey(r[0])) {
                tmap.get(r[0]).add(r[1]);
            } else {
                tmap.put(r[0],new HashSet<>());
                tmap.get(r[0]).add(r[1]);
            }

        }
        answer = new int[id_list.length];
        for (Map.Entry<String, HashSet<String>> entry : tmap.entrySet() ) {
            for(String e :entry.getValue()) {
                System.out.println(entry.getKey()+"가 신고한 "+e+"는 : 신고 한 유저가 "+map.get(e)+" 입니다.");
                if(map.get(e).size() >= k) {
                    result.put(entry.getKey(),result.get(entry.getKey())+1);
                }
            };
        }

        for (int i = 0; i < id_list.length ; i++) {
            answer[i] = result.get(id_list[i]);
        }
        return answer;
    }
}
