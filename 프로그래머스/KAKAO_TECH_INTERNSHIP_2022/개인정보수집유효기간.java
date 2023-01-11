package 프로그래머스.KAKAO_TECH_INTERNSHIP_2022;

import java.util.*;
import java.util.regex.Pattern;

public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        System.out.println(
                solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}
                ));
        System.out.println(
                solution("2020.01.01",new String[]{"Z 3", "D 5"},new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}
                ));
    }
//https://stackoverflow.com/questions/7935858/the-split-method-in-java-does-not-work-on-a-dot
    private static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        String[] tArray = today.split(Pattern.quote("."));
        int[] todayArray = Arrays.stream(today.split(Pattern.quote("."))).mapToInt(Integer::parseInt).toArray();
        Map<String,Integer> termMap = new HashMap<String,Integer>();
        for (String term: terms) {
            String[] t =term.split(" ");
            termMap.put(t[0],Integer.parseInt(t[1]));
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] privacie = privacies[i].split(" ");
            int[] privacieDayArray = Arrays.stream(privacie[0].split(Pattern.quote("."))).mapToInt(Integer::parseInt).toArray();
            int termMonth = termMap.get(privacie[1]);
            privacieDayArray[0] += termMonth/12;
            privacieDayArray[1] += termMonth%12;
            privacieDayArray[2] -= 1;
            if(privacieDayArray[2] == 0) {
                privacieDayArray[1] -= 1;
                privacieDayArray[2] = 28;
            }
            if(dayCompare(todayArray,privacieDayArray)){
                result.add(i+1);
            }
        }
        answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    private static boolean dayCompare(int[] today,int[] privace) {
        // today가 더크면 ()true, 작으면 false;
        int convertToday = today[0]*(28*12)+today[1]*30+today[2];
        int convertPrivace = privace[0]*(28*12)+privace[1]*28+privace[2];
        if (convertToday <= convertPrivace) {
            return false;
        }else {
            return true; // 파기;
        }
    }
}
