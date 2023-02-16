package 프로그래머스.연습문제;

import java.util.ArrayList;

public class 삼총사 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(solution(new int[]{-1, 1, -1, 1}));
    }
    public static int solution(int[] number) {
        int answer = 0;
        boolean[] visited = new boolean[number.length];

        return answer;
    }

    static ArrayList<int[]> combination(int[] arr, boolean[] visited, int start, int n, int r,ArrayList<int[]> list) {
        if(r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            list.add(new int[]{r});
            return list;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1,list);
            visited[i] = false;
        }
    }
}
