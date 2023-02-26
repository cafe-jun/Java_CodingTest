package 프로그래머스.연습문제;

import java.util.Stack;

public class 혼자서하는틱택토 {
    static int[][] testBoard = new int[3][3];
    static int num = 0;
    static int total = 0;
    static int[] line = new int[8];
    static int xWin = 0;
    static int oWin = 0;
    static int x = 0;
    static int o = 0;

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"O.X", ".O.", "..X"}));
        System.out.println(solution(new String[]{"OOO", "...", "XXX"}));
        System.out.println(solution(new String[]{"...", ".X.", "..."}));
        System.out.println(solution(new String[]{"...", "...", "..."}));
    }
    public static int solution(String[] board) {
        for (int i = 0; i < 9; i++) {
            switch (board[i / 3].charAt(i % 3)) {
                case 'O':
                    num = 10;
                    break;
                case 'X':
                    num = 1;
                    break;
                case '.':
                    num = 0;
                    break;
            }

            line[i / 3] += num;
            line[3 + i % 3] += num;
            if (i / 3 == i % 3)
                line[6] += num;
            if (i / 3 + i % 3 == 2)
                line[7] += num;

            total += num;
        }
        for (int i : line) {
            if (i == 30)
                oWin++;
            if (i == 3)
                xWin++;
        }

        o = total / 10;
        x = total % 10;
        if (o < x || o > x + 1)
            return 0;

        if (oWin > 0) {
            if (o == x || oWin > 2)
                return 0;
        }
        if (xWin > 0) {
            if (o > x || xWin > 1)
                return 0;
        }
        return 1;
    }
}
