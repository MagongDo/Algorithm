import java.util.Scanner;

public class Main {
    static int n, o;  
    static int A = 0;  
    static int B = 0; 
    static int asum = 0; 
    static int bsum = 0; 
    static String prev = "00:00"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); 
 
        for (int i = 0; i < n; i++) {
            o = sc.nextInt(); 
            String s = sc.next(); 

            if (A > B) {
                asum = go(asum, s);
            } 
            else if (B > A) {
                bsum = go(bsum, s);
            }
            
            if (o == 1) A++;
            else        B++;
            prev = s;
        }
        
        if (A > B) {
            asum = go(asum, "48:00");
        } else if (B > A) {
            bsum = go(bsum, "48:00");
        }

        System.out.println(printTime(asum));
        System.out.println(printTime(bsum));

        sc.close();
    }

    private static int go(int sum, String current) {
        return sum + (changeToInt(current) - changeToInt(prev));
    }

    private static int changeToInt(String a) {
        int minutes = Integer.parseInt(a.substring(0, 2));
        int seconds = Integer.parseInt(a.substring(3, 5));
        return minutes * 60 + seconds;
    }

    private static String printTime(int timeInSeconds) {
        int mm = timeInSeconds / 60;
        int ss = timeInSeconds % 60;
        return String.format("%02d:%02d", mm, ss);
    }
}
