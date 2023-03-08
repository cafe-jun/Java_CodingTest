package 프로그래머스.연습문제;

public class 바탕화면정리 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{".#...", "..#..", "...#."}));
        System.out.println(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."}));
        System.out.println(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}));
        System.out.println(solution(new String[]{"..", "#."}));
    }
    public static int[] solution(String[] wallpaper) {
        int[] answer = {};
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if(wallpaper[i].charAt(j) == '#'){
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i+1);
                    maxY = Math.max(maxY, j+1);
                }
            }
        }
        answer = new int[]{minX,minY,maxX,maxY};
        return answer;
    }
}
