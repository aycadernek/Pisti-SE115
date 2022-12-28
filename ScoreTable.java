
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Formatter;

public class ScoreTable {
    Score[] scoretable;
    public ScoreTable(){
        try {
            Scanner reader = null;
            scoretable= new Score[10];
            reader = new Scanner(Paths.get("out/production/se115/ScoreTable.txt"));
            reader.nextLine();
            for (int i = 0; i < 10; i++) {
                if (!reader.hasNextLine()) {
                    break;
                }
                String[] line = reader.nextLine().split(" ");
                scoretable[i] = new Score(line[0], Integer.parseInt(line[1]));
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
   
}
