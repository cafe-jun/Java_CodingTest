package 프로그래머스.KAKAO_TECH_INTERNSHIP_2022;

import java.util.HashMap;
import java.util.Map;

public class 택배배달과수거하기 {
    public static void main(String[] args) {
        System.out.println(solution(4,5,new int[]{1, 0, 3, 1, 2},new int[]{0, 3, 0, 4, 0});

    }
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = -1;
        // 배달하기
        Map<Integer,Integer> deMap = new HashMap<>();
        int d_cap = cap;
        for (int i = n-1; i >= 0; i--) {
            int turn = deliveries[i] / cap;
            if(deliveries[i])
        }
        return answer;
    }
}
