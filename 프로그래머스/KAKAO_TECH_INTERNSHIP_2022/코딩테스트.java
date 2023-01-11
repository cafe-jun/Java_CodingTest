package 프로그래머스.KAKAO_TECH_INTERNSHIP_2022;

import java.util.PriorityQueue;

// 1. 문제를 봐도 더이상 풀이 방법이 떠오르지 않아 어떻게 푸는지만 확인함
// 2. 다익스트라 라고하는제 잘 모르겠다
// 3. 다익스트라로 풀어보자
// 다익스트라
// 다익스트라로 계산할 때는 각 노드에 도착할 때 마다 최단 거리가 보장됩니다. <- 왜
// 알고보니 dp 문제임


public class 코딩테스트 {
    public static void main(String[] args) {
        System.out.println(solution(10	,10,new int[][]{{10,15,2,1,2},{20,20,3,3,4}}));

    }
    public static int solution(int alp, int cop, int[][] problems) {
        int answer = 0;
        // 목표치를 구해보자
        // dp 를 이용하기 위해서 이용해보자
        int goal_a = 0;
        int goal_c = 0;
        for (int i = 0; i < problems.length; i++) {
            goal_a = Math.max(problems[i][0],goal_a);
            goal_c = Math.max(problems[i][1],goal_c);

        }
        if(goal_a<=alp&&goal_c<=cop){
            return 0;
        }
        if(alp>=goal_a){
            alp=goal_a;
        }
        if(cop>=goal_c){
            cop=goal_c;
        }

        int[][] dp =new int[goal_a+2][goal_c+2];
        for(int i=alp;i<=goal_a;i++){
            for(int j=cop;j<=goal_c;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        dp[alp][cop]=0;

        for(int i=alp;i<=goal_a;i++){
            for(int j=cop;j<=goal_c;j++){

                dp[i+1][j]=Math.min(dp[i+1][j],dp[i][j]+1);

                dp[i][j+1]=Math.min(dp[i][j+1],dp[i][j]+1);

                for(int[] p :problems){

                    if(i>=p[0]&&j>=p[1]){
                        if(i+p[2]>goal_a&&j+p[3]>goal_c){
                            dp[goal_a][goal_c]=Math.min(dp[goal_a][goal_c],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]>goal_a){
                            dp[goal_a][j+p[3]]=Math.min(dp[goal_a][j+p[3]],dp[i][j]+p[4]);
                        }
                        else if(j+p[3]>goal_c){
                            dp[i+p[2]][goal_c]=Math.min(dp[i+p[2]][goal_c],dp[i][j]+p[4]);
                        }
                        else if(i+p[2]<=goal_a&&j+p[3]<=goal_c){
                            dp[i+p[2]][j+p[3]]=Math.min(dp[i+p[2]][j+p[3]],dp[i][j]+p[4]);
                        }
                    }

                }
            }
        }
        return dp[goal_a][goal_c];
    }
};
