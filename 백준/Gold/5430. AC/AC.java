import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      sc.nextLine();

      for(int i=0;i<n;i++){
          String s = sc.nextLine();
          int m = sc.nextInt();
          sc.nextLine();
          String x = sc.nextLine();

          String xCopy = x.substring(1,x.length()-1);
          Boolean check = true;
          ArrayList<String> xArray;
          if(xCopy.isEmpty()){
              xArray = new ArrayList<>();
          }
          else{
              xArray = Arrays.stream(xCopy.split(","))
                      .map(String::trim) // 각 요소의 앞뒤 공백 제거
                      .collect(Collectors.toCollection(ArrayList::new));
          }
          int arrayCount = 0;
          for(int j=0;j<s.length();j++)
          {

              if(s.charAt(j)=='R'){
                arrayCount++;
              }
              else if(s.charAt(j)=='D'){
                  if(arrayCount%2==0 && !xArray.isEmpty()){
                      xArray.remove(0);
                  }
                  else if(arrayCount%2==1 && !xArray.isEmpty()) {
                      xArray.remove(xArray.size()-1);
                  }
                  else{
                      check=false;
                      break;
                  }
              }
          }
          if(arrayCount%2==0&&check){
              System.out.print("[");
              for(int j=0;j<xArray.size();j++){
                  if(j!=xArray.size()-1){
                      System.out.print(xArray.get(j)+",");
                  }
                  else System.out.print(xArray.get(j));
              }
              System.out.println("]");
          }
          else if (arrayCount%2==1&&check){
              System.out.print("[");
              for(int j=xArray.size()-1;j>=0;j--){
                  if(j!=0){
                      System.out.print(xArray.get(j)+",");
                  }
                  else System.out.print(xArray.get(j));
              }
              System.out.println("]");
          }
          else{
              System.out.println("error");
          }

      }
  }
}
