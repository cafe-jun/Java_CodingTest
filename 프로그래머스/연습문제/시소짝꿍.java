package 프로그래머스.연습문제;

import java.util.*;

public class 시소짝꿍 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{100,180,360,100,270}));
    }
    public static long solution(int[] weights) {
        int answer = 0;
        return answer;
    }
    // 유클리드 호제법
//    public static int gcd(int a, int b) {
//        if(a%b == 0) {
//            return b;
//        }
//        return gcd(b, a%b);
//    }
//    long answer = 0;
//    Set<int[]> hashSet = new HashSet<>();
//        for (int i = 0; i < weights.length-1; i++) {
//        for (int j = i+1; j < weights.length; j++) {
//            hashSet.add(new int[]{weights[i],weights[j]});
//        }
//    }
//    Map<String,Integer> map = new HashMap<>();
//    Iterator<int[]> it = hashSet.iterator();
//        while(it.hasNext()) {
//        int[] result = it.next();
//        String str = Integer.toString(result[0])+":"+Integer.toString(result[1]);
//        int g = 0;
//        if(map.containsKey(str)) {
//            g = map.get(str);
//        } else {
//            g = gcd(result[0],result[1]);
//            map.put(str,g);
//        }
//        if(result[0]/g <= 4 && result[1]/g <= 4) {
//            answer += 1;
//        }
//    }
//        return answer;
}

