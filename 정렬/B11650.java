/**
 *  문제 이름 : 좌표 정렬하기
 * 
 *  난 이  도 : 실버 5
 * 
 *  아이디어 : x좌표 증가하는 순서대로 단 x좌표가 동일하면 y좌표로 정렬
 * 
 *  해    설 : 
 *              class 선언 후 Comparetor를 사용.
 *              compare를 사용하여 sort시킴             
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


 import java.io.*;
import java.util.ArrayList; 
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class coordinate {
    int x;
    int y;

    public coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

 public class B11650 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
     public static void main(String[] args) throws IOException{
         int repeat_num = Integer.parseInt(input.readLine());
        List<coordinate> list = new ArrayList<>();

        for (int i = 0; i < repeat_num; i++) {
            StringTokenizer token = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(token.nextToken());
            int y = Integer.parseInt(token.nextToken());

            coordinate c = new coordinate(x, y);
            list.add(c);
        }
        
        list.sort(new Comparator<coordinate>() {
            @Override
            public int compare(coordinate o1, coordinate o2) {
                if(o1.x == o2.x) {
                    return o1.y - o2.y;
                } else {
                    return o1.x - o2.x;
                }
            }
        });

        for(coordinate i : list) {
            output.write(String.valueOf(i.x) + " "+String.valueOf(i.y)+"\n");
        }

        input.close();
        output.close();
     }
 }