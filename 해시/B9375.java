/**
 *  문제 이름 : 패션왕 신해빈
 * 
 *  난 이  도 : 실버 3
 * 
 *  아이디어 : 해빈이는 패션이 매우 민감해서 한번 입었던 옷의 조합을 다시 입지 않는다.
 *            해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경 대신 렌즈를 착용하거나 해야한다.
 *            가진 의상들이 주어졌을 때 과연 해빈이는 알몸이 아닌 상태로 몇일 동안 돌아다닐 수 있을까?
 * 
 *  해    설 : 
 *              Hash에 ArrayList를 사용하여 전반적인 신체 부위에 대한 값은 Key로 대입 한 후 value는 세부적인 아이템을 매칭하였다.
 *              그래서 ArrayList의 길이를 보고 동일한 신체 부위가 존재하면 같은 List에 들어가게 설정하였다.
 * 
 * 
 *              조합의 경우 
 *                  옷을 입는 경우와 못 입는 경우를 나눠서 설정하면 된다. 즉 head gear와 body가 있을 때 head gear의 세부 item +1(안입을 수 있는 경우 추가)
 *                  한 후 head gear * body 곱해주고 알몸인 경우를 뺴주면 되는 문제였다.
 * 
 *              조합에서 많은 시행 착오가 있어서 해설을 보고 해결을 하였다.
 * 
 *  시간 복잡도 : 
 * 
 *  공간 복잡도 : 
 *    
 */


import java.io.*;
import java.util.*;
 
 public class B9375 {
     static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
     static BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
     public static void main(String[] args) throws IOException{
         int tc = Integer.parseInt(input.readLine());

         for (int i = 0; i < tc; i++) {
            int repeat_num = Integer.parseInt(input.readLine());
            int answer = 1;

            HashMap<String, ArrayList<String>> map = new HashMap();

            for (int j = 0; j < repeat_num; j++) {
                StringTokenizer token = new StringTokenizer(input.readLine());

                String kindOfCloth = token.nextToken(); // hat, sunglasses 같이 큰 부류에서 파생되서 나온 세부 옷 정보
                String partOfCloth = token.nextToken(); // headgear, face 같이 큰 범위의 부분

                if(!(map.containsKey(partOfCloth))) {
                    map.put(partOfCloth, new ArrayList<>());
                }

                map.get(partOfCloth).add(kindOfCloth);
            }

            for(String key : map.keySet()) {
                int len = (map.get(key).size()+1);

                answer *= len;
            }

            output.write(String.valueOf(answer-1)+"\n");
         }
 
         input.close();
         output.close();
     }
 }