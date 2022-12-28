
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
    public Score intable(int i) {
        return scoretable[i];
    }
    public ScoreTable updatetable(Score user){
        int index=-1;
        ScoreTable newtable= new ScoreTable();

        for(int i=0;i<scoretable.length;i++){
            if (user.getScore()>scoretable[i].getScore()){
                index=i;
                break;
            }
        }
        if (index==-1){
            System.out.println("You can not enter the High Score Table\n");
            return newtable;
        }
        System.out.println("You entered the High Score Table\n");
        for(int i=0;i<scoretable.length;i++){
            if (i==index){
                newtable.intable(i).setName(user.getName());
                newtable.intable(i).setScore(user.getScore());
            }else if(i>index){
                newtable.intable(i).setName(scoretable[i-1].getName());
                newtable.intable(i).setScore(scoretable[i-1].getScore());
            }else{
                newtable.intable(i).setName(scoretable[i].getName());
                newtable.intable(i).setScore(scoretable[i].getScore());
            }
        }
        return newtable;
    }
    public void write(){
        try{
            Formatter f = null;
            f = new Formatter("out/production/se115/ScoreTable.txt");
            f.format("HIGH SCORE TABLE\n");
            for (int i = 0; i < 10; i++) {
                f.format(scoretable[i].getName()+" "+scoretable[i].getScore()+"\n");
            }
            f.close();
        }catch(Exception e) {
        }
    }

    public void readtable(){
        try {
            Scanner reader = null;
            reader = new Scanner(Paths.get("out/production/se115/ScoreTable.txt"));
            while(true){
                if (!reader.hasNextLine()) {
                    break;
                }
                System.out.println(reader.nextLine());
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
