import java.io.*;
import java.util.*;

public class Main_2615_오목 {
    static int[][] board;
    static class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int answerWinner, answerRow, answerCol;
    static boolean endFlag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[19][19];

        for(int row = 0; row < 19; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int col = 0; col < 19; col++) {
                board[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        answerWinner = 0;
        endFlag = false;

        search : for(int row = 0; row < 19; row++) {
            for(int col = 0; col < 19; col++) {
                if(board[row][col] != 0) {
                    checkAnswer(row, col);
                    if(endFlag) {
                        break search;
                    }
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        sb.append(answerWinner + "\n");

        if(answerWinner != 0) {
            answerRow++;
            answerCol++;

            sb.append(answerRow + " " + answerCol);
        }

        System.out.println(sb.toString());
        br.close();
    }

    static void checkAnswer(int row, int col) {
        Pos checkLogic = new Pos(-1, -1);

        for(int i = 0 ; i < 4; i++) {
            switch (i) {
                case 0 : checkLogic = checkRow(row, col); break;
                case 1 : checkLogic = checkCol(row, col); break;
                case 2 : checkLogic = checkULDR(row, col); break;
                case 3 : checkLogic = checkURDL(row, col); break;
            }

            int resultRow = checkLogic.row;
            int resultCol = checkLogic.col;

            if(resultRow != -1 && resultCol != -1) {
                answerWinner = board[row][col];
                answerRow = resultRow;
                answerCol = resultCol;

                endFlag = true;

                break;
            }
        }
    }

    static Pos checkRow(int row, int col) {
        int cnt = 1;
        int colPos = col;
        int color = board[row][col];

        int returnRow = row;
        int returnCol = col;

        for(int d = 0; d < 5; d++) {
            colPos = colPos - 1;

            if(colPos < 0 || board[row][colPos] != color)
                break;

            returnCol = colPos;
            cnt++;
        }

        colPos = col;
        for(int d = 0; d < 5; d++) {
            colPos = colPos + 1;

            if(colPos >= 19 || board[row][colPos] != color)
                break;

            cnt++;
        }

        if(cnt == 5)
            return new Pos(returnRow, returnCol);
        else
            return new Pos(-1, -1);
    }

    static Pos checkCol(int row, int col) {
        int cnt = 1;
        int rowPos = row;
        int color = board[row][col];

        int returnRow = row;
        int returnCol = col;

        for(int d = 0; d < 5; d++) {
            rowPos = rowPos - 1;

            if(rowPos < 0 || board[rowPos][col] != color)
                break;

            returnRow = rowPos;
            cnt++;
        }

        rowPos = row;
        for(int d = 0; d < 5; d++) {
            rowPos = rowPos + 1;

            if(rowPos >= 19 || board[rowPos][col] != color)
                break;

            cnt++;
        }

        if(cnt == 5)
            return new Pos(returnRow, returnCol);
        else
            return new Pos(-1, -1);
    }

    static Pos checkULDR(int row, int col) {
        int cnt = 1;
        int rowPos = row;
        int colPos = col;
        int color = board[row][col];

        int returnRow = row;
        int returnCol = col;

        for(int d = 0; d < 5; d++) {
            rowPos = rowPos - 1;
            colPos = colPos - 1;

            if(rowPos < 0 || colPos < 0 || board[rowPos][colPos] != color)
                break;

            returnRow = rowPos;
            returnCol = colPos;

            cnt++;
        }

        rowPos = row;
        colPos = col;
        for(int d = 0; d < 5; d++) {
            rowPos = rowPos + 1;
            colPos = colPos + 1;

            if(rowPos >= 19 || colPos >= 19|| board[rowPos][colPos] != color)
                break;

            cnt++;
        }

        if(cnt == 5)
            return new Pos(returnRow, returnCol);
        else
            return new Pos(-1, -1);
    }

    static Pos checkURDL(int row, int col) {
        int cnt = 1;
        int rowPos = row;
        int colPos = col;
        int color = board[row][col];

        int returnRow = row;
        int returnCol = col;

        for(int d = 0; d < 5; d++) {
            rowPos = rowPos - 1;
            colPos = colPos + 1;

            if(rowPos < 0 || colPos >= 19 || board[rowPos][colPos] != color)
                break;

            cnt++;
        }

        rowPos = row;
        colPos = col;
        for(int d = 0; d < 5; d++) {
            rowPos = rowPos + 1;
            colPos = colPos - 1;

            if(rowPos >= 19 || colPos < 0 || board[rowPos][colPos] != color)
                break;

            returnRow = rowPos;
            returnCol = colPos;

            cnt++;
        }

        if(cnt == 5)
            return new Pos(returnRow, returnCol);
        else
            return new Pos(-1, -1);
    }
}
