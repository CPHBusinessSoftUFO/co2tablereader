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

    public static void main(String[] args) throws FileNotFoundException, IOException {
        for (int repeat = 0; repeat < 100; repeat++) {
            try (BufferedReader br = new BufferedReader(new FileReader(INFILE))) {
                String line = br.readLine();
                if (repeat == 0) System.out.println(line);
                line = br.readLine();
                long sum = 0;
                while (line != null) {
                    //for (int i = 0; i<10;i++){
                    String[] elements = line.split(",");
                    sum += Integer.parseInt(elements[2]);
                    line = br.readLine();
                }
                if (repeat==0) System.out.println("Total: " + sum);
            }
        }
    }
}
