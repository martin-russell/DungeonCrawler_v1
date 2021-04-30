abstract class Monster {

    String name;
    String description;
    int injury = 0;
    int dicePool;

    abstract void attack();
    abstract void defend();
    abstract void die();

    String describe(){
        String x = this.name + ": " + this.description;
        return x;
    }

}