package 프로그래머스.KAKAO2017예선;

import java.util.*;

public class 카카오프렌즈컬러링북 {
    static int[] dr;
    static int[] dc;
    public static void main(String[] args) {
        System.out.println(solution(6,4,new int[][]{{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}}));
        System.out.println(solution(6,4,new int[][]{{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}}));
    }
    public static int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,-1,0,1};
        Queue<Pointer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[][] matrix = copy(picture);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]&& matrix[i][j] > 0) {
                    int area = matrix[i][j];
                    map.put(i+1,1);
                    queue.offer(new Pointer(i,j));
                    visited[i][j] = true;
                    while(!queue.isEmpty()) {
                        Pointer pointer = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int nr = dr[k]+pointer.r;
                            int nc = dc[k]+pointer.c;
                            if(0<=nr && nr<m &&0<=nc && nc<n) {
                                if(matrix[nr][nc] == area && !visited[nr][nc]) {
                                    queue.offer(new Pointer(nr,nc));
                                    map.put(i+1,map.get(i+1)+1);
                                    visited[nr][nc] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        answer[0] = map.size();
        for (Integer key : map.keySet()) {
            answer[1] = Math.max(map.get(key),answer[1]);
        }
        return answer;
    }

    public static int[][] copy(int[][] src) {
        if (src == null) {
            return null;
        }

        int[][] copy = new int[src.length][];

        for (int i = 0; i < src.length; i++) {
            copy[i] = new int[src[i].length];
            System.arraycopy(src[i], 0, copy[i], 0, src[i].length);
        }

        return copy;
    }
}

class Pointer {
    int r;
    int c;

    public Pointer(int r, int c) {
        this.r = r;
        this.c = c;
    }
}