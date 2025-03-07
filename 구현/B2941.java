
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] kroatia = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};

        String string = input.readLine();

        String[] one_alphabet = string.split("");

        int count_lenght_3 = 0;
        int count_lenght_2 = 0;

        for(int i = 1; i < one_alphabet.length; i++) {
            int index = i-1;

            String cmp_string_2 = one_alphabet[index] + one_alphabet[i];

            if(index < one_alphabet.length-2) {
                String cmp_string_3 = "dz=";

                String original = one_alphabet[index] + one_alphabet[index + 1] + one_alphabet[index + 2];

                if(cmp_string_3.equals(original)) {
                    count_lenght_3++;
                    i+=2;
                }
            }

            for(int j = 0; j < kroatia.length; j++) {
                if(cmp_string_2.equals(kroatia[j])) {
                    i++;
                    count_lenght_2++;
                    break;
                }
            }
            
        }

        output.write(String.valueOf(count_lenght_2+count_lenght_3+(one_alphabet.length-(count_lenght_2*2+count_lenght_3*3))));


        input.close();
        output.close();
    }   
}