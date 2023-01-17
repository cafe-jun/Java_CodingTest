package 프로그래머스.KAKAO_TECH_INTERNSHIP_2022;

import java.util.ArrayList;
import java.util.List;

public class 이모티콘할인행사 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{40, 10000},{25, 10000}},new int[]{7000, 9000}));
        System.out.println(solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}
        },new int[]{1300, 1500, 1600, 4900}));
    }
    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int[] discount = new int[]{40,30,20,10};
        // em+discount 순열 만들기
        // 전부 40일때
        int r = emoticons.length;
        int service = 0;
        int money = 0;
        int totalMoney = 0;
        int resultService = 0;
        int resultMoney = 0;
        ArrayList<int[]> list = permutation(discount,new int[r],0,r,new ArrayList<int[]>());
        for (int[] percent:  list) {
            service = 0;
            totalMoney = 0;
            // 유저 순회
            for (int k = 0; k < users.length; k++) {
                money = 0;
                // 이모티콘 뭘살지 확인
                for (int i = 0; i < emoticons.length; i++) {

                    // 기준 보다 할인율이 크면 구매
                    if(percent[i] >= users[k][0]) {
                        money += emoticons[i]-(emoticons[i]*(percent[i]*0.01));
                        // 카카오톡 서비스 가입
                        if(users[k][1] <= money) {
                            // 구매 취소
                            money = 0;
                            service += 1;
                            break;
                        }
                    }
                }
                totalMoney += money;
            }
            if(resultService < service) {
                resultService = service;
                resultMoney = totalMoney;
            }else if(service == resultService) {
                resultMoney = Math.max(totalMoney,resultMoney);
            };
        }
        answer = new int[]{resultService,resultMoney};
        return answer;
    }
    public static ArrayList<int[]> permutation(int[] arr, int[] out, int depth, int r,ArrayList<int[]> list){
        if(depth == r){
            // call by reference 로 clone
            list.add(out.clone());
            return list;
        }
        for(int i=0; i<arr.length; i++){
            out[depth] = arr[i];
            permutation(arr, out, depth+1, r,list);
        }
        return list;
    }
}
