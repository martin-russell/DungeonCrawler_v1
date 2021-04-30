import java.util.Random;

public class Roller {

    Random rand = new Random();

    public int roll(int dp){
    int successes = 0;
    for (int i = 0; i<dp; i++){
        int dice = rand.nextInt(6)+1;
        if (dice >= 3){
            successes++;
        }
        }
    return successes;
    }
}