import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        Map<String, Double> map = new HashMap<String, Double>();
        String line;
        double total = 0.0; 


        while ((line = br.readLine()) != null && !line.isEmpty()) {
            map.put(line, map.getOrDefault(line, 0.0) + 1.0);
            total++; 
        }

        List<String> trees = new ArrayList<>(map.keySet());
        Collections.sort(trees);

        
        for(String tree : trees){
            double percentage = ((double) map.get(tree) / total) * 100;
            System.out.printf("%s %.4f\n", tree, percentage);

        }


    }
}
