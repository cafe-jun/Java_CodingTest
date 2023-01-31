package 프로그래머스.연습문제;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 뒤에있는큰수찾기 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{2, 3, 3, 5}));
        System.out.println(solution(new int[]{9, 1, 5, 3, 6, 2}));
    }
    public static int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        int temp = 0;
        int left = numbers[0];
        for (int i = 0; i < numbers.length-1; i++) {
            boolean check = false;
            if(left >= numbers[i] && i > 0 && check) {
                list.add(temp);
                left = numbers[i];
                continue;
            }
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] < numbers[j]) {
                    list.add(numbers[j]);
                    temp = numbers[j];
                    check = true;
                    break;
                }
            }
            if(check == false){
                temp = -1;
                list.add(-1);
            }
        }
        list.add(-1);
        answer = list.stream().mapToInt(i->i).toArray();
        return answer;
    }
}

class Num implements Comparable<Num> {
    int value;
    int index;

    public Num(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(Num target) {
        // 역순으로 정렬
        return this.value<= target.value ? -1 : 1;
    }
}