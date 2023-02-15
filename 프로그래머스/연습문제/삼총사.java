package 프로그래머스.연습문제;

public class 삼총사 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-2, 3, 0, 2, -5}));
        System.out.println(solution(new int[]{-3, -2, -1, 0, 1, 2, 3}));
        System.out.println(solution(new int[]{-1, 1, -1, 1}));
    }
    public static int solution(int[] number) {
        int answer = 0;
        return answer;
    }

    static ArrayList<> combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {

            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
