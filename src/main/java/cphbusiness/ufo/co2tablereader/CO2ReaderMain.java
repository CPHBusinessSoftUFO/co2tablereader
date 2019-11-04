package cphbusiness.ufo.co2tablereader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author kasper
 */
public class CO2ReaderMain {

    // The next file is a local copy of: https://datahub.io/core/co2-fossil-by-nation/r/fossil-fuel-co2-emissions-by-nation.csv
    private static final String INFILE = "fossil-fuel-co2-emissions-by-nation_csv.csv";
    //390944446

    public static void main(String[] args) throws FileNotFoundException, IOException {
        final int N = 1000;
        for (int repeat = 1; repeat <= N; repeat++) {
            try (BufferedReader br = new BufferedReader(new FileReader(INFILE))) {
                String line = br.readLine();
                if (repeat == N) System.out.println(line);
                line = br.readLine();
                long sum = 0;
                while (line != null) {
                    String[] elements = line.split(",");
                    sum += Integer.parseInt(elements[2]);
                    line = br.readLine();
                }
                if (repeat==N) System.out.println("Total: " + sum);
            }
        }
    }
    public static int getTotal(String line){
        int index =0;
        while(line.charAt(index)!=',') index++; // find first ,
        index++;
        while(line.charAt(index)!=',') index++; // find seccond ,
        index++;
        int total = 0; char c;
        while((c = line.charAt(index))!=',') {
            total = total*10+(c-'0');
            index++;}
        return total;
    }
}
