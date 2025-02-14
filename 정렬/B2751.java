
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class B2751 {
    public static void main(String argc[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat_num = Integer.parseInt(input.readLine());

        ArrayList<Integer> array = new ArrayList<Integer>();

        for(int i =0; i< repeat_num; i++) {
            int num = Integer.parseInt(input.readLine());
            array.add(num);
        }

        Collections.sort(array);

        for(int i = 0; i< repeat_num; i++) {
            output.write(String.valueOf(array.get(i))+"\n");
        }

        input.close();
        output.close();
    }
}
