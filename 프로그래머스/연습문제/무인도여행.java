package 프로그래머스.연습문제;


import java.util.LinkedList;
import java.util.Queue;

public class 무인도여행 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"X591X","X1X5X","X231X", "1XXX1"}));
        System.out.println(solution(new String[]{"XXX","XXX","XXX"}));
    }
    public static int[] solution(String[] maps) {
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int[] answer = {};
        Queue<Point> pointList = new LinkedList();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps.length; j++) {
                if(maps[i].charAt(j) != 'X') {
                    pointList.offer(new Point(i,j));
                }
            }
        }

        // bfs
        while(!pointList.isEmpty()) {
            Point point = pointList.poll();
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + point.r;
                int nc = dc[i] + point.c;
                if (0 <= nr && nr < maps.length && 0 <= nc && nc < maps[0].length()) {
                    if (maps[nr].charAt(nc) != 'X'){
                       int temp = Character.getNumericValue(maps[point.r].charAt(point.c));

                    }
                }
            }
        }


        return answer;
    }
}

class Point {
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
    int r;
    int c;

}