package 프로그래머스.연습문제;

import java.util.HashMap;
import java.util.Map;

public class 공원산책 {

    public static void main(String[] args) {
//        System.out.println(solution(new String[]{"SOO","OOO","OOO"},new String[]{"E 2","S 2","W 1"}));
//        System.out.println(solution(new String[]{"SOO","OXX","OOO"},new String[]{"E 2","S 2","W 1"}));
        System.out.println(solution(new String[]{"OSO","OOO","OXO","OOO"},new String[]{"E 2","S 3","W 1"}));
    }
    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        Map<String,Integer> dMap = new HashMap<>();
        int h = park.length;
        int w = park[0].length();
        char[][] matrix = new char[h][w];
        Map<String,Integer[]> map = new HashMap<>();
        map.put("W",new Integer[]{0,-1});
        map.put("E",new Integer[]{0,1});
        map.put("N",new Integer[]{-1,0});
        map.put("S",new Integer[]{1,0});
        int[] point = new int[2];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                char d = park[i].charAt(j);
                if(d == 'S') {
                    point[0] = i;
                    point[1] = j;
                }
                matrix[i][j] = park[i].charAt(j);
            }
        }
        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            String dir = route[0];
            String move = route[1];
            Integer[] step = map.get(dir);
            int[] temp = point.clone();
            boolean isMove = true;
            for (int j = 0; j < Integer.parseInt(move); j++) {
                int dr = step[0]+temp[0];
                int dc = step[1]+temp[1];
                if(0<=dr && dr<h && 0<=dc && dc<w && matrix[dr][dc] == 'O') {
                    temp[0] = dr;
                    temp[1] = dc;
                } else {
                    isMove = false;
                    break;
                }
            }
            if(isMove) {
                point[0] = temp[0];
                point[1] = temp[1];
            }
        }
        answer[0] = point[0];
        answer[1] = point[1];
        return answer;
    }
}



