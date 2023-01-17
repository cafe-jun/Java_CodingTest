package 프로그래머스.KAKAO_TECH_INTERNSHIP_2022;

import java.util.Stack;

public class 택배배달과수거하기 {
    public static void main(String[] args) {
        System.out.println(solution(4,5,new int[]{1, 0, 3, 1, 2},new int[]{0, 3, 0, 4, 0}));

    }
    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int box = 0;
        // 배달하기
        Stack<Integer> dstack = new Stack<>();
        Stack<Integer> pstack = new Stack<>();

        for (int i = 0; i < n; i++) {
            dstack.push(deliveries[i]);
            pstack.push(pickups[i]);
        }

        while(!dstack.empty() && dstack.peek() == 0) {
            dstack.pop();
        }
        while(!pstack.empty() && pstack.peek() == 0) {
            pstack.pop();
        }
        while(!dstack.empty() && !pstack.empty()){
            answer += Math.max(dstack.size()*2,pstack.size()*2);
            box = 0;
            while(!dstack.empty() && box <= cap) {
                if(dstack.peek()+box <= cap) {
                    box += dstack.peek();
                } else {
                    int temp = dstack.pop();
                    temp -= (cap-box);
                    dstack.push(temp);
                    break;
                }
                dstack.pop();
            }
            box = 0;
            while(!pstack.empty() && box <= cap) {
                if(pstack.peek()+box <= cap) {
                    box += pstack.peek();
                } else {
                    int temp = pstack.pop();
                    temp -= (cap-box);
                    pstack.push(temp);
                    break;
                }
                pstack.pop();
            }
        }


        return answer;
    }
}
