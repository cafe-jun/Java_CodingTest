package 프로그래머스.연습문제;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
        System.out.println(solution(new String[]{"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}));
    }
    public static int solution(String[] maps) {
        int answer = 0;
        char[][] matrix = new char[maps.length][maps[0].length()];
        Queue<Points> leverQueue = new LinkedList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                int temp = maps[i].charAt(j);
                if(temp == 'S') {
                    matrix[i][j] = 'X';
                    leverQueue.offer(new Points(i,j,0));
                }
                matrix[i][j] = maps[i].charAt(j);
            }
        }
        Queue<Points> exitQueue = new LinkedList<>();
        char[][] leverMatrix = copy(matrix);
        leverMatrix[leverQueue.peek().r][leverQueue.peek().r] = 'X';
        while(!leverQueue.isEmpty()) {
            Points points = leverQueue.poll();
            if(matrix[points.r][points.c] == 'L') {
                exitQueue.offer(new Points(points.r, points.c, points.time));
                break;
            }
            for (int i = 0; i <4; i++) {
                int nr = dr[i]+ points.r;
                int nc = dc[i]+ points.c;
                if(0<=nr && nr<maps.length && 0<=nc && nc<maps[0].length()) {
                    char prev = leverMatrix[nr][nc];
                    if (prev != 'X') {
                        leverMatrix[nr][nc] = 'X';
                        leverQueue.offer(new Points(nr, nc, points.time + 1));
                    }
                }
            }
        }
        char[][] exitMatrix = copy(matrix);
        while(!exitQueue.isEmpty()) {
            Points points = exitQueue.poll();
            if(matrix[points.r][points.c] == 'E') {
                answer += points.time;
                break;
            }
            for (int i = 0; i <4; i++) {
                int nr = dr[i]+ points.r;
                int nc = dc[i]+ points.c;
                if(0<=nr && nr<maps.length && 0<=nc && nc<maps[0].length()) {
                    char prev = exitMatrix[nr][nc];
                    if(prev != 'X') {
                        exitMatrix[nr][nc] = 'X';
                        exitQueue.offer(new Points(nr, nc, points.time + 1));
                    }
                }
            }
        }

        if(answer == 0) {
            return -1;
        }
        return answer;
    }
    public static char[][] copy(char[][] src) {
        if (src == null) {
            return null;
        }

        char[][] copy = new char[src.length][];

        for (int i = 0; i < src.length; i++) {
            copy[i] = new char[src[i].length];
            System.arraycopy(src[i], 0, copy[i], 0, src[i].length);
        }

        return copy;
    }
}

class Points {
    int r;
    int c;

    int time;
    public Points(int r, int c,int time) {
        this.r = r;
        this.c = c;
        this.time = time;
    }
}