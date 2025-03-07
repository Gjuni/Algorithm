import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1920 {
    public static int _binarysearch(int n, ArrayList<Integer> answer_sheet) {
        int start = 0;
        int end = answer_sheet.size()-1;

        while(start <= end) {
            int middle = (start+end)/2;

            if(n == answer_sheet.get(middle)) {
                return 1;
            } else if(n > answer_sheet.get(middle)) {
                start = middle+1;
            } else if(n < answer_sheet.get(middle)) {
                end = middle-1;
            }
        }
        return 0;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        // 해답지
        int N = Integer.parseInt(input.readLine());
        ArrayList<Integer> answer_sheet = new ArrayList<Integer>();
        StringTokenizer token = new StringTokenizer(input.readLine());

        for(int i =0; i< N; i++) {
            answer_sheet.add(Integer.parseInt(token.nextToken()));
        }
        Collections.sort(answer_sheet);
        

        // N과 비교해서 정답 출력할 수들
        int M = Integer.parseInt(input.readLine());
        int[] cmp_array = new int[M];
        token = new StringTokenizer(input.readLine());

        for(int i =0; i< M; i++) {
            cmp_array[i] = Integer.parseInt(token.nextToken());
        }

        for(int i =0; i< M; i++) {
            int result = _binarysearch(cmp_array[i], answer_sheet);
            output.write(String.valueOf(result)+"\n");
        }
    
        input.close();
        output.close();
    }
}
