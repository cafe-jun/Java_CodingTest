package 프로그래머스.연습문제;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 연속부분수열합의개수 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{7,9,1,1,4}));
    }
    public static int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < elements.length; i++) {

            for (int j = 0; j < elements.length; j++) {
                int temp = cycleCombination(elements,j,i+j);
                set.add(temp);
            }
            ;
        }
        set.add(Arrays.stream(elements).sum());
        answer = set.size();
        return answer;
    }

    static int cycleCombination(int[] arr,int start,int r) {
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = start; i < r; i++) {
            if(i < arr.length) {
                list.add(arr[i]);
            } else {

               list.add(arr[i-arr.length]);
            }
        }
        return list.stream().reduce(0,(a,b)->  a + b);
    }
}
