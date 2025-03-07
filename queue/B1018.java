import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1018 {
    public static int solve(String[] chess_board, int width, int height) {
        String[] white_Board = {
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW"
        };

        String[] Black_Board = {
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB",
            "BWBWBWBW",
            "WBWBWBWB"
        };

        int answer_black = Integer.MAX_VALUE;
        int answer_white = Integer.MAX_VALUE;
        int inc_height = height - 8;
        int inc_width = width - 8;

        for (int ih = 0; ih <= inc_height; ih++) {
            for (int iw = 0; iw <= inc_width; iw++) {
                int reset_black_ans = 0;
                int reset_white_ans = 0;

                for (int h = ih; h < 8 + ih; h++) {
                    String black = Black_Board[h - ih];
                    String white = white_Board[h - ih];
                    String main_board = chess_board[h];

                    for (int w = iw; w < 8 + iw; w++) {
                        char compare_black = black.charAt(w - iw);
                        char compare_white = white.charAt(w - iw);
                        char main_chess = main_board.charAt(w);

                        if (main_chess != compare_black) {
                            reset_black_ans++;
                        }

                        if (main_chess != compare_white) {
                            reset_white_ans++;
                        }
                    }
                }

                answer_black = Math.min(answer_black, reset_black_ans);
                answer_white = Math.min(answer_white, reset_white_ans);
            }
        }

        return Math.min(answer_black, answer_white);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer token = new StringTokenizer(input.readLine());

        int height = Integer.parseInt(token.nextToken());
        int width = Integer.parseInt(token.nextToken());

        String[] chess_board = new String[height];

        for (int h = 0; h < height; h++) {
            chess_board[h] = input.readLine();
        }

        output.write(String.valueOf(solve(chess_board, width, height)));

        input.close();
        output.close();
    }
}
